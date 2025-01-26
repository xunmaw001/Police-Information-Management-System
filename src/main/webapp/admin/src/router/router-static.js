import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import jiechexinxi from '@/views/modules/jiechexinxi/list'
    import jingche from '@/views/modules/jingche/list'
    import lingdao from '@/views/modules/lingdao/list'
    import news from '@/views/modules/news/list'
    import renliziyuan from '@/views/modules/renliziyuan/list'
    import xingzhengrenyuan from '@/views/modules/xingzhengrenyuan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryJiechexinxiYesno from '@/views/modules/dictionaryJiechexinxiYesno/list'
    import dictionaryJingche from '@/views/modules/dictionaryJingche/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryStatus from '@/views/modules/dictionaryStatus/list'
    import jiechexinxiAdd from '@/views/modules/jiechexinxi/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryJiechexinxiYesno',
        name: '借车状态',
        component: dictionaryJiechexinxiYesno
    }
    ,{
        path: '/dictionaryJingche',
        name: '警车类型',
        component: dictionaryJingche
    },
	,{
	    path: '/jiechexinxiAdd',
	    name: '警车申请',
	    component: jiechexinxiAdd
	}
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryStatus',
        name: '警车状态',
        component: dictionaryStatus
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/jiechexinxi',
        name: '借车记录',
        component: jiechexinxi
      }
    ,{
        path: '/jingche',
        name: '警车信息',
        component: jingche
      }
    ,{
        path: '/lingdao',
        name: '领导',
        component: lingdao
      }
    ,{
        path: '/news',
        name: '公告资讯',
        component: news
      }
    ,{
        path: '/renliziyuan',
        name: '人力资源',
        component: renliziyuan
      }
    ,{
        path: '/xingzhengrenyuan',
        name: '行政人员',
        component: xingzhengrenyuan
      }
    ,{
        path: '/yonghu',
        name: '警员',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
