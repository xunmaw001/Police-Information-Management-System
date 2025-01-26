
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 借车记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiechexinxi")
public class JiechexinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JiechexinxiController.class);

    private static final String TABLE_NAME = "jiechexinxi";

    @Autowired
    private JiechexinxiService jiechexinxiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JingcheService jingcheService;//警车信息
    @Autowired
    private LingdaoService lingdaoService;//领导
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private RenliziyuanService renliziyuanService;//人力资源
    @Autowired
    private XingzhengrenyuanService xingzhengrenyuanService;//行政人员
    @Autowired
    private YonghuService yonghuService;//警员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("警员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("领导".equals(role))
            params.put("lingdaoId",request.getSession().getAttribute("userId"));
        else if("人力资源".equals(role))
            params.put("renliziyuanId",request.getSession().getAttribute("userId"));
        else if("行政人员".equals(role))
            params.put("xingzhengrenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jiechexinxiService.queryPage(params);

        //字典表数据转换
        List<JiechexinxiView> list =(List<JiechexinxiView>)page.getList();
        for(JiechexinxiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiechexinxiEntity jiechexinxi = jiechexinxiService.selectById(id);
        if(jiechexinxi !=null){
            //entity转view
            JiechexinxiView view = new JiechexinxiView();
            BeanUtils.copyProperties( jiechexinxi , view );//把实体数据重构到view中
            //级联表 警车信息
            //级联表
            JingcheEntity jingche = jingcheService.selectById(jiechexinxi.getJingcheId());
            if(jingche != null){
            BeanUtils.copyProperties( jingche , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingcheId(jingche.getId());
            }
            //级联表 警员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiechexinxi.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiechexinxiEntity jiechexinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiechexinxi:{}",this.getClass().getName(),jiechexinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("警员".equals(role))
            jiechexinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiechexinxiEntity> queryWrapper = new EntityWrapper<JiechexinxiEntity>()
            .eq("jingche_id", jiechexinxi.getJingcheId())
            .eq("yonghu_id", jiechexinxi.getYonghuId())
            .eq("jiechexinxi_time", new SimpleDateFormat("yyyy-MM-dd").format(jiechexinxi.getJiechexinxiTime()))
            .eq("jiechexinxi_num", jiechexinxi.getJiechexinxiNum())
            .in("jiechexinxi_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiechexinxiEntity jiechexinxiEntity = jiechexinxiService.selectOne(queryWrapper);
        if(jiechexinxiEntity==null){
            jiechexinxi.setJiechexinxiYesnoTypes(1);
            jiechexinxi.setInsertTime(new Date());
            jiechexinxi.setCreateTime(new Date());
            jiechexinxiService.insert(jiechexinxi);
            return R.ok();
        }else {
            if(jiechexinxiEntity.getJiechexinxiYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jiechexinxiEntity.getJiechexinxiYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiechexinxiEntity jiechexinxi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiechexinxi:{}",this.getClass().getName(),jiechexinxi.toString());
        JiechexinxiEntity oldJiechexinxiEntity = jiechexinxiService.selectById(jiechexinxi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("警员".equals(role))
//            jiechexinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiechexinxiService.updateById(jiechexinxi);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JiechexinxiEntity jiechexinxiEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,jiechexinxiEntity:{}",this.getClass().getName(),jiechexinxiEntity.toString());

        JiechexinxiEntity oldJiechexinxi = jiechexinxiService.selectById(jiechexinxiEntity.getId());//查询原先数据

        if(jiechexinxiEntity.getJiechexinxiYesnoTypes() == 2){//通过
            JingcheEntity jingcheEntity = new JingcheEntity();
            jingcheEntity.setId(oldJiechexinxi.getJingcheId());
            jingcheEntity.setStatusTypes(2);
            jingcheService.updateById(jingcheEntity);

        }
        jiechexinxiService.updateById(jiechexinxiEntity);//审核

        return R.ok();
    }



    @RequestMapping("/huanche")
    public R huanche(Integer id, HttpServletRequest request){
        JiechexinxiEntity oldJiechexinxi = jiechexinxiService.selectById(id);
        oldJiechexinxi.setJiechexinxiYesnoTypes(4);
        JingcheEntity jingcheEntity = new JingcheEntity();
        jingcheEntity.setId(oldJiechexinxi.getJingcheId());
        jingcheEntity.setStatusTypes(1);
        jingcheService.updateById(jingcheEntity);
        jiechexinxiService.updateById(oldJiechexinxi);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiechexinxiEntity> oldJiechexinxiList =jiechexinxiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiechexinxiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JiechexinxiEntity> jiechexinxiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiechexinxiEntity jiechexinxiEntity = new JiechexinxiEntity();
//                            jiechexinxiEntity.setJingcheId(Integer.valueOf(data.get(0)));   //警车 要改的
//                            jiechexinxiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //警员 要改的
//                            jiechexinxiEntity.setJiechexinxiText(data.get(0));                    //借车原因 要改的
//                            jiechexinxiEntity.setJiechexinxiTime(sdf.parse(data.get(0)));          //借车日期 要改的
//                            jiechexinxiEntity.setJiechexinxiNum(Integer.valueOf(data.get(0)));   //借车时间/天 要改的
//                            jiechexinxiEntity.setJiechexinxiYesnoTypes(Integer.valueOf(data.get(0)));   //借车状态 要改的
//                            jiechexinxiEntity.setJiechexinxiYesnoText(data.get(0));                    //审核回复 要改的
//                            jiechexinxiEntity.setInsertTime(date);//时间
//                            jiechexinxiEntity.setCreateTime(date);//时间
                            jiechexinxiList.add(jiechexinxiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiechexinxiService.insertBatch(jiechexinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

