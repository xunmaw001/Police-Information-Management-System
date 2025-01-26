const base = {
    get() {
        return {
            url : "http://localhost:8080/jingwuxinxiguanli/",
            name: "jingwuxinxiguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jingwuxinxiguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "警务信息管理系统"
        } 
    }
}
export default base
