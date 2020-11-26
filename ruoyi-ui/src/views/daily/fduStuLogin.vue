<template>
  <div>
    <p></p>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label="学生姓名" prop="name">
        <el-input v-model="formData.name" placeholder="请输入学生姓名" :maxlength="10" clearable
                  :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item label="学号" prop="student_no">
        <el-input v-model="formData.student_no" placeholder="请输入学号" :maxlength="15" clearable
                  :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">Login</el-button>
        <el-button @click="resetForm">Reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {checkStudent} from "@/api/daily/fduStuLogin";

export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        name: undefined,
        student_no: undefined,
      },
      rules: {
        name: [{
          required: true,
          message: '请输入学生姓名',
          trigger: 'blur'
        }],
        student_no: [{
          required: true,
          message: '请输入学号',
          trigger: 'blur'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        checkStudent(this.formData.name,this.formData.student_no).then(
          response=>{
            this.$store.state.stu_no = this.formData.student_no;
            this.$router.push('/fduStuCommit');
          }
        )

      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
