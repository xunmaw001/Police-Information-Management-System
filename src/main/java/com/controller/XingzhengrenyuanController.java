
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
 * 行政人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xingzhengrenyuan")
public class XingzhengrenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(XingzhengrenyuanController.class);

    private static final String TABLE_NAME = "xingzhengrenyuan";

    @Autowired
    private XingzhengrenyuanService xingzhengrenyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiechexinxiService jiechexinxiService;//借车记录
    @Autowired
    private JingcheService jingcheService;//警车信息
    @Autowired
    private LingdaoService lingdaoService;//领导
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private RenliziyuanService renliziyuanService;//人力资源
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
        params.put("xingzhengrenyuanDeleteStart",1);params.put("xingzhengrenyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xingzhengrenyuanService.queryPage(params);

        //字典表数据转换
        List<XingzhengrenyuanView> list =(List<XingzhengrenyuanView>)page.getList();
        for(XingzhengrenyuanView c:list){
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
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectById(id);
        if(xingzhengrenyuan !=null){
            //entity转view
            XingzhengrenyuanView view = new XingzhengrenyuanView();
            BeanUtils.copyProperties( xingzhengrenyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody XingzhengrenyuanEntity xingzhengrenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xingzhengrenyuan:{}",this.getClass().getName(),xingzhengrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XingzhengrenyuanEntity> queryWrapper = new EntityWrapper<XingzhengrenyuanEntity>()
            .eq("username", xingzhengrenyuan.getUsername())
            .or()
            .eq("xingzhengrenyuan_phone", xingzhengrenyuan.getXingzhengrenyuanPhone())
            .or()
            .eq("xingzhengrenyuan_id_number", xingzhengrenyuan.getXingzhengrenyuanIdNumber())
            .eq("xingzhengrenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XingzhengrenyuanEntity xingzhengrenyuanEntity = xingzhengrenyuanService.selectOne(queryWrapper);
        if(xingzhengrenyuanEntity==null){
            xingzhengrenyuan.setXingzhengrenyuanDelete(1);
            xingzhengrenyuan.setInsertTime(new Date());
            xingzhengrenyuan.setCreateTime(new Date());
            xingzhengrenyuan.setPassword("123456");
            xingzhengrenyuanService.insert(xingzhengrenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者人员手机号或者人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XingzhengrenyuanEntity xingzhengrenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xingzhengrenyuan:{}",this.getClass().getName(),xingzhengrenyuan.toString());
        XingzhengrenyuanEntity oldXingzhengrenyuanEntity = xingzhengrenyuanService.selectById(xingzhengrenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xingzhengrenyuan.getXingzhengrenyuanPhoto()) || "null".equals(xingzhengrenyuan.getXingzhengrenyuanPhoto())){
                xingzhengrenyuan.setXingzhengrenyuanPhoto(null);
        }

            xingzhengrenyuanService.updateById(xingzhengrenyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XingzhengrenyuanEntity> oldXingzhengrenyuanList =xingzhengrenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XingzhengrenyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XingzhengrenyuanEntity xingzhengrenyuanEntity = new XingzhengrenyuanEntity();
            xingzhengrenyuanEntity.setId(id);
            xingzhengrenyuanEntity.setXingzhengrenyuanDelete(2);
            list.add(xingzhengrenyuanEntity);
        }
        if(list != null && list.size() >0){
            xingzhengrenyuanService.updateBatchById(list);
        }

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
            List<XingzhengrenyuanEntity> xingzhengrenyuanList = new ArrayList<>();//上传的东西
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
                            XingzhengrenyuanEntity xingzhengrenyuanEntity = new XingzhengrenyuanEntity();
//                            xingzhengrenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            xingzhengrenyuanEntity.setPassword("123456");//密码
//                            xingzhengrenyuanEntity.setXingzhengrenyuanName(data.get(0));                    //人员名称 要改的
//                            xingzhengrenyuanEntity.setXingzhengrenyuanPhone(data.get(0));                    //人员手机号 要改的
//                            xingzhengrenyuanEntity.setXingzhengrenyuanIdNumber(data.get(0));                    //人员身份证号 要改的
//                            xingzhengrenyuanEntity.setXingzhengrenyuanPhoto("");//详情和图片
//                            xingzhengrenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xingzhengrenyuanEntity.setXingzhengrenyuanEmail(data.get(0));                    //人员邮箱 要改的
//                            xingzhengrenyuanEntity.setXingzhengrenyuanDelete(1);//逻辑删除字段
//                            xingzhengrenyuanEntity.setInsertTime(date);//时间
//                            xingzhengrenyuanEntity.setCreateTime(date);//时间
                            xingzhengrenyuanList.add(xingzhengrenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //人员手机号
                                if(seachFields.containsKey("xingzhengrenyuanPhone")){
                                    List<String> xingzhengrenyuanPhone = seachFields.get("xingzhengrenyuanPhone");
                                    xingzhengrenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xingzhengrenyuanPhone = new ArrayList<>();
                                    xingzhengrenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("xingzhengrenyuanPhone",xingzhengrenyuanPhone);
                                }
                                //人员身份证号
                                if(seachFields.containsKey("xingzhengrenyuanIdNumber")){
                                    List<String> xingzhengrenyuanIdNumber = seachFields.get("xingzhengrenyuanIdNumber");
                                    xingzhengrenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xingzhengrenyuanIdNumber = new ArrayList<>();
                                    xingzhengrenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xingzhengrenyuanIdNumber",xingzhengrenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XingzhengrenyuanEntity> xingzhengrenyuanEntities_username = xingzhengrenyuanService.selectList(new EntityWrapper<XingzhengrenyuanEntity>().in("username", seachFields.get("username")).eq("xingzhengrenyuan_delete", 1));
                        if(xingzhengrenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XingzhengrenyuanEntity s:xingzhengrenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //人员手机号
                        List<XingzhengrenyuanEntity> xingzhengrenyuanEntities_xingzhengrenyuanPhone = xingzhengrenyuanService.selectList(new EntityWrapper<XingzhengrenyuanEntity>().in("xingzhengrenyuan_phone", seachFields.get("xingzhengrenyuanPhone")).eq("xingzhengrenyuan_delete", 1));
                        if(xingzhengrenyuanEntities_xingzhengrenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XingzhengrenyuanEntity s:xingzhengrenyuanEntities_xingzhengrenyuanPhone){
                                repeatFields.add(s.getXingzhengrenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //人员身份证号
                        List<XingzhengrenyuanEntity> xingzhengrenyuanEntities_xingzhengrenyuanIdNumber = xingzhengrenyuanService.selectList(new EntityWrapper<XingzhengrenyuanEntity>().in("xingzhengrenyuan_id_number", seachFields.get("xingzhengrenyuanIdNumber")).eq("xingzhengrenyuan_delete", 1));
                        if(xingzhengrenyuanEntities_xingzhengrenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XingzhengrenyuanEntity s:xingzhengrenyuanEntities_xingzhengrenyuanIdNumber){
                                repeatFields.add(s.getXingzhengrenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xingzhengrenyuanService.insertBatch(xingzhengrenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectOne(new EntityWrapper<XingzhengrenyuanEntity>().eq("username", username));
        if(xingzhengrenyuan==null || !xingzhengrenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(xingzhengrenyuan.getXingzhengrenyuanDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(xingzhengrenyuan.getId(),username, "xingzhengrenyuan", "行政人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","行政人员");
        r.put("username",xingzhengrenyuan.getXingzhengrenyuanName());
        r.put("tableName","xingzhengrenyuan");
        r.put("userId",xingzhengrenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XingzhengrenyuanEntity xingzhengrenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XingzhengrenyuanEntity> queryWrapper = new EntityWrapper<XingzhengrenyuanEntity>()
            .eq("username", xingzhengrenyuan.getUsername())
            .or()
            .eq("xingzhengrenyuan_phone", xingzhengrenyuan.getXingzhengrenyuanPhone())
            .or()
            .eq("xingzhengrenyuan_id_number", xingzhengrenyuan.getXingzhengrenyuanIdNumber())
            .andNew()
            .eq("xingzhengrenyuan_delete", 1)
            ;
        XingzhengrenyuanEntity xingzhengrenyuanEntity = xingzhengrenyuanService.selectOne(queryWrapper);
        if(xingzhengrenyuanEntity != null)
            return R.error("账户或者人员手机号或者人员身份证号已经被使用");
        xingzhengrenyuan.setXingzhengrenyuanDelete(1);
        xingzhengrenyuan.setInsertTime(new Date());
        xingzhengrenyuan.setCreateTime(new Date());
        xingzhengrenyuanService.insert(xingzhengrenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectById(id);
        xingzhengrenyuan.setPassword("123456");
        xingzhengrenyuanService.updateById(xingzhengrenyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(xingzhengrenyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(xingzhengrenyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        xingzhengrenyuan.setPassword(newPassword);
		xingzhengrenyuanService.updateById(xingzhengrenyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectOne(new EntityWrapper<XingzhengrenyuanEntity>().eq("username", username));
        if(xingzhengrenyuan!=null){
            xingzhengrenyuan.setPassword("123456");
            xingzhengrenyuanService.updateById(xingzhengrenyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXingzhengrenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XingzhengrenyuanEntity xingzhengrenyuan = xingzhengrenyuanService.selectById(id);
        if(xingzhengrenyuan !=null){
            //entity转view
            XingzhengrenyuanView view = new XingzhengrenyuanView();
            BeanUtils.copyProperties( xingzhengrenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

