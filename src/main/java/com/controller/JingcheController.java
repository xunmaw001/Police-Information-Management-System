
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
 * 警车信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingche")
public class JingcheController {
    private static final Logger logger = LoggerFactory.getLogger(JingcheController.class);

    private static final String TABLE_NAME = "jingche";

    @Autowired
    private JingcheService jingcheService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiechexinxiService jiechexinxiService;//借车记录
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
        PageUtils page = jingcheService.queryPage(params);

        //字典表数据转换
        List<JingcheView> list =(List<JingcheView>)page.getList();
        for(JingcheView c:list){
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
        JingcheEntity jingche = jingcheService.selectById(id);
        if(jingche !=null){
            //entity转view
            JingcheView view = new JingcheView();
            BeanUtils.copyProperties( jingche , view );//把实体数据重构到view中
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
    public R save(@RequestBody JingcheEntity jingche, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingche:{}",this.getClass().getName(),jingche.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JingcheEntity> queryWrapper = new EntityWrapper<JingcheEntity>()
            .eq("jingche_name", jingche.getJingcheName())
            .eq("jingche_types", jingche.getJingcheTypes())
            .eq("status_types", jingche.getStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingcheEntity jingcheEntity = jingcheService.selectOne(queryWrapper);
        if(jingcheEntity==null){
            jingche.setInsertTime(new Date());
            jingche.setCreateTime(new Date());
            jingcheService.insert(jingche);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingcheEntity jingche, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingche:{}",this.getClass().getName(),jingche.toString());
        JingcheEntity oldJingcheEntity = jingcheService.selectById(jingche.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            jingcheService.updateById(jingche);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingcheEntity> oldJingcheList =jingcheService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingcheService.deleteBatchIds(Arrays.asList(ids));

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
            List<JingcheEntity> jingcheList = new ArrayList<>();//上传的东西
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
                            JingcheEntity jingcheEntity = new JingcheEntity();
//                            jingcheEntity.setJingcheUuidNumber(data.get(0));                    //警车编号 要改的
//                            jingcheEntity.setJingcheName(data.get(0));                    //警车名称 要改的
//                            jingcheEntity.setJingcheTypes(Integer.valueOf(data.get(0)));   //警车类型 要改的
//                            jingcheEntity.setStatusTypes(Integer.valueOf(data.get(0)));   //警车状态 要改的
//                            jingcheEntity.setJingcheContent("");//详情和图片
//                            jingcheEntity.setInsertTime(date);//时间
//                            jingcheEntity.setCreateTime(date);//时间
                            jingcheList.add(jingcheEntity);


                            //把要查询是否重复的字段放入map中
                                //警车编号
                                if(seachFields.containsKey("jingcheUuidNumber")){
                                    List<String> jingcheUuidNumber = seachFields.get("jingcheUuidNumber");
                                    jingcheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingcheUuidNumber = new ArrayList<>();
                                    jingcheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingcheUuidNumber",jingcheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //警车编号
                        List<JingcheEntity> jingcheEntities_jingcheUuidNumber = jingcheService.selectList(new EntityWrapper<JingcheEntity>().in("jingche_uuid_number", seachFields.get("jingcheUuidNumber")));
                        if(jingcheEntities_jingcheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingcheEntity s:jingcheEntities_jingcheUuidNumber){
                                repeatFields.add(s.getJingcheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [警车编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingcheService.insertBatch(jingcheList);
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

