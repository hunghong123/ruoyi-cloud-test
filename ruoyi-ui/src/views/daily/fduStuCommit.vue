<template>
  <div>
    <p></p>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label="今日日期" prop="todayDate">
        <el-date-picker v-model="formData.todayDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                        :style="{width: '30%'}" placeholder="请选择今日日期" clearable></el-date-picker>
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="formData.name" placeholder="请输入姓名" readonly :disabled='true' :maxlength="10" clearable
                  :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item label="学号" prop="studentNo">
        <el-input v-model="formData.studentNo" placeholder="请输入学号" readonly :disabled='true' :maxlength="20" show-word-limit clearable
                  :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item label="是否在校" prop="onCampus">
        <el-radio-group v-model="formData.onCampus" size="medium">
          <el-radio v-for="(item, index) in onCampusOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="所在区域" prop="currentDistrict">
        <el-radio-group v-model="formData.currentDistrict" size="medium">
          <el-radio v-for="(item, index) in currentDistrictOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="所在地点" prop="currentLocation">
        <el-input v-model="formData.currentLocation" placeholder="请输入所在地点" clearable
                  :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item label="体温范围" prop="temperature">
        <el-radio-group v-model="formData.temperature" size="medium">
          <el-radio v-for="(item, index) in temperatureOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否发烧咳嗽乏力" prop="feeling">
        <el-radio-group v-model="formData.feeling" size="medium">
          <el-radio v-for="(item, index) in feelingOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否接触中高风险地区人员" prop="contact1">
        <el-radio-group v-model="formData.contact1" size="medium">
          <el-radio v-for="(item, index) in contact1Options" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否接触疑似确诊人员" prop="contact2">
        <el-radio-group v-model="formData.contact2" size="medium">
          <el-radio v-for="(item, index) in contact2Options" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否处于隔离期" prop="isolate">
        <el-radio-group v-model="formData.isolate" size="medium">
          <el-radio v-for="(item, index) in isolateOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否有其他注意事项" prop="other">
        <el-radio-group v-model="formData.other" size="medium">
          <el-radio v-for="(item, index) in otherOptions" :key="index" :label="item.value"
                    :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="其他注意事项" prop="remark">
        <el-input v-model="formData.remark" type="textarea" placeholder="请输入其他注意事项" :maxlength="50"
                  :autosize="{minRows: 4, maxRows: 4}" :style="{width: '30%'}"></el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">Submit</el-button>
        <el-button @click="resetForm">Reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {checkStudent} from "@/api/daily/fduStuLogin";
import {getStuInfo, saveDailyUpdate} from "@/api/daily/fduStuCommit";

export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        todayDate: new Date(),
        name: undefined,
        studentNo: '',
        onCampus: 1,
        currentDistrict: 1,
        currentLocation: undefined,
        temperature: 1,
        feeling: 0,
        contact1: 0,
        contact2: 0,
        isolate: 0,
        other: 0,
        remark: undefined,
      },
      rules: {
        todayDate: [{
          required: true,
          message: '请选择今日日期',
          trigger: 'change'
        }],
        name: [],
        studentNo: [{
          required: true,
          message: '请输入学号',
          trigger: 'blur'
        }],
        on_campus: [{
          required: true,
          message: '是否在校不能为空',
          trigger: 'change'
        }],
        currentDistrict: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'change'
        }],
        currentLocation: [],
        temperature: [{
          required: true,
          message: '体温范围不能为空',
          trigger: 'change'
        }],
        feeling: [{
          required: true,
          message: '是否发烧咳嗽乏力不能为空',
          trigger: 'change'
        }],
        contact1: [{
          required: true,
          message: '是否接触中高风险地区人员不能为空',
          trigger: 'change'
        }],
        contact2: [{
          required: true,
          message: '是否接触疑似确诊人员不能为空',
          trigger: 'change'
        }],
        isolate: [{
          required: true,
          message: '是否处于隔离期不能为空',
          trigger: 'change'
        }],
        other: [{
          required: true,
          message: '是否有其他注意事项不能为空',
          trigger: 'change'
        }],
        remark: [],
      },
      onCampusOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      currentDistrictOptions: [{
        "label": "中国大陆",
        "value": 1
      }, {
        "label": "中国香港",
        "value": 2
      }, {
        "label": "中国澳门",
        "value": 3
      }, {
        "label": "中国台湾",
        "value": 4
      }, {
        "label": "其他国家",
        "value": 5
      }],
      temperatureOptions: [{
        "label": "37.2℃以下",
        "value": 1
      }, {
        "label": "27.3℃~38℃",
        "value": 2
      }, {
        "label": "38℃以上",
        "value": 3
      }],
      feelingOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      contact1Options: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      contact2Options: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      isolateOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      otherOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {
    this.formData.studentNo = this.$store.state.stu_no;
    this.formData.name = this.loadName(this.formData.studentNo);
  },
  methods: {
    loadName(stu_no) {
      getStuInfo(stu_no).then(response=>{
        console.log(response);
        this.formData.name = response.data.name;
      })
    },

    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        saveDailyUpdate(this.formData).then(
          response=>{
            this.msgSuccess(response.msg)
            this.$router.push('/fduStuLogin');
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
