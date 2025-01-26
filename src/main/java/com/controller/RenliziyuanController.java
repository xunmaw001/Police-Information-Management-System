
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
 * 人力资源
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/renliziyuan")
public class RenliziyuanController {
    private static final Logger logger = LoggerFactory.getLogger(RenliziyuanController.class);

    private static final String TABLE_NAME = "renliziyuan";

    @Autowired
    private RenliziyuanService renliziyuanService;


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
        params.put("renliziyuanDeleteStart",1);params.put("renliziyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = renliziyuanService.queryPage(params);

        //字典表数据转换
        List<RenliziyuanView> list =(List<RenliziyuanView>)page.getList();
        for(RenliziyuanView c:list){
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
        RenliziyuanEntity renliziyuan = renliziyuanService.selectById(id);
        if(renliziyuan !=null){
            //entity转view
            RenliziyuanView view = new RenliziyuanView();
            BeanUtils.copyProperties( renliziyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody RenliziyuanEntity renliziyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,renliziyuan:{}",this.getClass().getName(),renliziyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<RenliziyuanEntity> queryWrapper = new EntityWrapper<RenliziyuanEntity>()
            .eq("username", renliziyuan.getUsername())
            .or()
            .eq("renliziyuan_phone", renliziyuan.getRenliziyuanPhone())
            .or()
            .eq("renliziyuan_id_number", renliziyuan.getRenliziyuanIdNumber())
            .eq("renliziyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenliziyuanEntity renliziyuanEntity = renliziyuanService.selectOne(queryWrapper);
        if(renliziyuanEntity==null){
            renliziyuan.setRenliziyuanDelete(1);
            renliziyuan.setInsertTime(new Date());
            renliziyuan.setCreateTime(new Date());
            renliziyuan.setPassword("123456");
            renliziyuanService.insert(renliziyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者人员手机号或者人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenliziyuanEntity renliziyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,renliziyuan:{}",this.getClass().getName(),renliziyuan.toString());
        RenliziyuanEntity oldRenliziyuanEntity = renliziyuanService.selectById(renliziyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(renliziyuan.getRenliziyuanPhoto()) || "null".equals(renliziyuan.getRenliziyuanPhoto())){
                renliziyuan.setRenliziyuanPhoto(null);
        }

            renliziyuanService.updateById(renliziyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<RenliziyuanEntity> oldRenliziyuanList =renliziyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<RenliziyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            RenliziyuanEntity renliziyuanEntity = new RenliziyuanEntity();
            renliziyuanEntity.setId(id);
            renliziyuanEntity.setRenliziyuanDelete(2);
            list.add(renliziyuanEntity);
        }
        if(list != null && list.size() >0){
            renliziyuanService.updateBatchById(list);
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
            List<RenliziyuanEntity> renliziyuanList = new ArrayList<>();//上传的东西
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
                            RenliziyuanEntity renliziyuanEntity = new RenliziyuanEntity();
//                            renliziyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            renliziyuanEntity.setPassword("123456");//密码
//                            renliziyuanEntity.setRenliziyuanName(data.get(0));                    //人员名称 要改的
//                            renliziyuanEntity.setRenliziyuanPhone(data.get(0));                    //人员手机号 要改的
//                            renliziyuanEntity.setRenliziyuanIdNumber(data.get(0));                    //人员身份证号 要改的
//                            renliziyuanEntity.setRenliziyuanPhoto("");//详情和图片
//                            renliziyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            renliziyuanEntity.setRenliziyuanEmail(data.get(0));                    //人员邮箱 要改的
//                            renliziyuanEntity.setRenliziyuanDelete(1);//逻辑删除字段
//                            renliziyuanEntity.setInsertTime(date);//时间
//                            renliziyuanEntity.setCreateTime(date);//时间
                            renliziyuanList.add(renliziyuanEntity);


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
                                if(seachFields.containsKey("renliziyuanPhone")){
                                    List<String> renliziyuanPhone = seachFields.get("renliziyuanPhone");
                                    renliziyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> renliziyuanPhone = new ArrayList<>();
                                    renliziyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("renliziyuanPhone",renliziyuanPhone);
                                }
                                //人员身份证号
                                if(seachFields.containsKey("renliziyuanIdNumber")){
                                    List<String> renliziyuanIdNumber = seachFields.get("renliziyuanIdNumber");
                                    renliziyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> renliziyuanIdNumber = new ArrayList<>();
                                    renliziyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("renliziyuanIdNumber",renliziyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<RenliziyuanEntity> renliziyuanEntities_username = renliziyuanService.selectList(new EntityWrapper<RenliziyuanEntity>().in("username", seachFields.get("username")).eq("renliziyuan_delete", 1));
                        if(renliziyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenliziyuanEntity s:renliziyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //人员手机号
                        List<RenliziyuanEntity> renliziyuanEntities_renliziyuanPhone = renliziyuanService.selectList(new EntityWrapper<RenliziyuanEntity>().in("renliziyuan_phone", seachFields.get("renliziyuanPhone")).eq("renliziyuan_delete", 1));
                        if(renliziyuanEntities_renliziyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenliziyuanEntity s:renliziyuanEntities_renliziyuanPhone){
                                repeatFields.add(s.getRenliziyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //人员身份证号
                        List<RenliziyuanEntity> renliziyuanEntities_renliziyuanIdNumber = renliziyuanService.selectList(new EntityWrapper<RenliziyuanEntity>().in("renliziyuan_id_number", seachFields.get("renliziyuanIdNumber")).eq("renliziyuan_delete", 1));
                        if(renliziyuanEntities_renliziyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenliziyuanEntity s:renliziyuanEntities_renliziyuanIdNumber){
                                repeatFields.add(s.getRenliziyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        renliziyuanService.insertBatch(renliziyuanList);
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
        RenliziyuanEntity renliziyuan = renliziyuanService.selectOne(new EntityWrapper<RenliziyuanEntity>().eq("username", username));
        if(renliziyuan==null || !renliziyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(renliziyuan.getRenliziyuanDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(renliziyuan.getId(),username, "renliziyuan", "人力资源");
        R r = R.ok();
        r.put("token", token);
        r.put("role","人力资源");
        r.put("username",renliziyuan.getRenliziyuanName());
        r.put("tableName","renliziyuan");
        r.put("userId",renliziyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody RenliziyuanEntity renliziyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<RenliziyuanEntity> queryWrapper = new EntityWrapper<RenliziyuanEntity>()
            .eq("username", renliziyuan.getUsername())
            .or()
            .eq("renliziyuan_phone", renliziyuan.getRenliziyuanPhone())
            .or()
            .eq("renliziyuan_id_number", renliziyuan.getRenliziyuanIdNumber())
            .andNew()
            .eq("renliziyuan_delete", 1)
            ;
        RenliziyuanEntity renliziyuanEntity = renliziyuanService.selectOne(queryWrapper);
        if(renliziyuanEntity != null)
            return R.error("账户或者人员手机号或者人员身份证号已经被使用");
        renliziyuan.setRenliziyuanDelete(1);
        renliziyuan.setInsertTime(new Date());
        renliziyuan.setCreateTime(new Date());
        renliziyuanService.insert(renliziyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        RenliziyuanEntity renliziyuan = renliziyuanService.selectById(id);
        renliziyuan.setPassword("123456");
        renliziyuanService.updateById(renliziyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        RenliziyuanEntity renliziyuan = renliziyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(renliziyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(renliziyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        renliziyuan.setPassword(newPassword);
		renliziyuanService.updateById(renliziyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        RenliziyuanEntity renliziyuan = renliziyuanService.selectOne(new EntityWrapper<RenliziyuanEntity>().eq("username", username));
        if(renliziyuan!=null){
            renliziyuan.setPassword("123456");
            renliziyuanService.updateById(renliziyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrRenliziyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        RenliziyuanEntity renliziyuan = renliziyuanService.selectById(id);
        if(renliziyuan !=null){
            //entity转view
            RenliziyuanView view = new RenliziyuanView();
            BeanUtils.copyProperties( renliziyuan , view );//把实体数据重构到view中

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

