<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='lingdao'"  label='领导名称' prop="lingdaoName">
               <el-input v-model="ruleForm.lingdaoName"  placeholder='领导名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='lingdao'"  label='领导手机号' prop="lingdaoPhone">
               <el-input v-model="ruleForm.lingdaoPhone"  placeholder='领导手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='lingdao'"  label='领导身份证号' prop="lingdaoIdNumber">
               <el-input v-model="ruleForm.lingdaoIdNumber"  placeholder='领导身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='lingdao'" label='领导头像' prop="lingdaoPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.lingdaoPhoto?$base.url+ruleForm.lingdaoPhoto:''"
                         @change="lingdaoPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='lingdao'"  label='领导邮箱' prop="lingdaoEmail">
               <el-input v-model="ruleForm.lingdaoEmail"  placeholder='领导邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='renliziyuan'"  label='人员名称' prop="renliziyuanName">
               <el-input v-model="ruleForm.renliziyuanName"  placeholder='人员名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='renliziyuan'"  label='人员手机号' prop="renliziyuanPhone">
               <el-input v-model="ruleForm.renliziyuanPhone"  placeholder='人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='renliziyuan'"  label='人员身份证号' prop="renliziyuanIdNumber">
               <el-input v-model="ruleForm.renliziyuanIdNumber"  placeholder='人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='renliziyuan'" label='人员头像' prop="renliziyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.renliziyuanPhoto?$base.url+ruleForm.renliziyuanPhoto:''"
                         @change="renliziyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='renliziyuan'"  label='人员邮箱' prop="renliziyuanEmail">
               <el-input v-model="ruleForm.renliziyuanEmail"  placeholder='人员邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xingzhengrenyuan'"  label='人员名称' prop="xingzhengrenyuanName">
               <el-input v-model="ruleForm.xingzhengrenyuanName"  placeholder='人员名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xingzhengrenyuan'"  label='人员手机号' prop="xingzhengrenyuanPhone">
               <el-input v-model="ruleForm.xingzhengrenyuanPhone"  placeholder='人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xingzhengrenyuan'"  label='人员身份证号' prop="xingzhengrenyuanIdNumber">
               <el-input v-model="ruleForm.xingzhengrenyuanIdNumber"  placeholder='人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='xingzhengrenyuan'" label='人员头像' prop="xingzhengrenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.xingzhengrenyuanPhoto?$base.url+ruleForm.xingzhengrenyuanPhoto:''"
                         @change="xingzhengrenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='xingzhengrenyuan'"  label='人员邮箱' prop="xingzhengrenyuanEmail">
               <el-input v-model="ruleForm.xingzhengrenyuanEmail"  placeholder='人员邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='警员名称' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='警员名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='警员手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='警员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='警员身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='警员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='警员头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='警员邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='警员邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu'
|| flag=='lingdao'
|| flag=='renliziyuan'
|| flag=='xingzhengrenyuan')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 警员
    // 注册的类型字段 警员
        // 性别
        sexTypesOptions : [],
// 注册表 领导
    // 注册的类型字段 领导
        // 性别
        sexTypesOptions : [],
// 注册表 人力资源
    // 注册的类型字段 人力资源
        // 性别
        sexTypesOptions : [],
// 注册表 行政人员
    // 注册的类型字段 行政人员
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 警员
// 注册表 领导
// 注册表 人力资源
// 注册表 行政人员
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 警员 的级联表
// 注册表 领导 的级联表
// 注册表 人力资源 的级联表
// 注册表 行政人员 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    lingdaoPhotoUploadChange(fileUrls) {
        this.ruleForm.lingdaoPhoto = fileUrls;
    },
    renliziyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.renliziyuanPhoto = fileUrls;
    },
    xingzhengrenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.xingzhengrenyuanPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.lingdaoName)&& 'lingdao'==this.flag){
                             this.$message.error('领导名称不能为空');
                             return
                         }

                             if( 'lingdao' ==this.flag && this.ruleForm.lingdaoPhone&&(!isMobile(this.ruleForm.lingdaoPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.lingdaoIdNumber)&& 'lingdao'==this.flag){
                             this.$message.error('领导身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.lingdaoPhoto)&& 'lingdao'==this.flag){
                             this.$message.error('领导头像不能为空');
                             return
                         }

                             if( 'lingdao' ==this.flag && this.ruleForm.lingdaoEmail&&(!isEmail(this.ruleForm.lingdaoEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.renliziyuanName)&& 'renliziyuan'==this.flag){
                             this.$message.error('人员名称不能为空');
                             return
                         }

                             if( 'renliziyuan' ==this.flag && this.ruleForm.renliziyuanPhone&&(!isMobile(this.ruleForm.renliziyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.renliziyuanIdNumber)&& 'renliziyuan'==this.flag){
                             this.$message.error('人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.renliziyuanPhoto)&& 'renliziyuan'==this.flag){
                             this.$message.error('人员头像不能为空');
                             return
                         }

                             if( 'renliziyuan' ==this.flag && this.ruleForm.renliziyuanEmail&&(!isEmail(this.ruleForm.renliziyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.xingzhengrenyuanName)&& 'xingzhengrenyuan'==this.flag){
                             this.$message.error('人员名称不能为空');
                             return
                         }

                             if( 'xingzhengrenyuan' ==this.flag && this.ruleForm.xingzhengrenyuanPhone&&(!isMobile(this.ruleForm.xingzhengrenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.xingzhengrenyuanIdNumber)&& 'xingzhengrenyuan'==this.flag){
                             this.$message.error('人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.xingzhengrenyuanPhoto)&& 'xingzhengrenyuan'==this.flag){
                             this.$message.error('人员头像不能为空');
                             return
                         }

                             if( 'xingzhengrenyuan' ==this.flag && this.ruleForm.xingzhengrenyuanEmail&&(!isEmail(this.ruleForm.xingzhengrenyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('警员名称不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('警员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('警员头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu'
|| this.flag=='lingdao'
|| this.flag=='renliziyuan'
|| this.flag=='xingzhengrenyuan')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
