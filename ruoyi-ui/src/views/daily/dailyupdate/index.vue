<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="今日日期" prop="todayDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.todayDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择今日日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="学号" prop="studentNo">
        <el-input
          v-model="queryParams.studentNo"
          placeholder="请输入学号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否在校" prop="onCampus">
        <el-select v-model="queryParams.onCampus" placeholder="请选择是否在校" clearable size="small">
          <el-option
            v-for="dict in onCampusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所在区域" prop="currentDistrict">
        <el-select v-model="queryParams.currentDistrict" placeholder="请选择所在区域" clearable size="small">
          <el-option
            v-for="dict in currentDistrictOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所在地点" prop="currentLocation">
        <el-input
          v-model="queryParams.currentLocation"
          placeholder="请输入所在地点"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体温范围" prop="temperature">
        <el-select v-model="queryParams.temperature" placeholder="请选择体温范围" clearable size="small">
          <el-option
            v-for="dict in temperatureOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否发烧咳嗽乏力" prop="feeling">
        <el-select v-model="queryParams.feeling" placeholder="请选择是否发烧咳嗽乏力" clearable size="small">
          <el-option
            v-for="dict in feelingOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否接触中高风险地区人员" prop="contact1">
        <el-select v-model="queryParams.contact1" placeholder="请选择是否接触中高风险地区人员" clearable size="small">
          <el-option
            v-for="dict in contact1Options"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否接触疑似确诊人员" prop="contact2">
        <el-select v-model="queryParams.contact2" placeholder="请选择是否接触疑似确诊人员" clearable size="small">
          <el-option
            v-for="dict in contact2Options"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否处于隔离期" prop="isolate">
        <el-select v-model="queryParams.isolate" placeholder="请选择是否处于隔离期" clearable size="small">
          <el-option
            v-for="dict in isolateOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否有其他注意事项" prop="other">
        <el-select v-model="queryParams.other" placeholder="请选择是否有其他注意事项" clearable size="small">
          <el-option
            v-for="dict in otherOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['daily:dailyupdate:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['daily:dailyupdate:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['daily:dailyupdate:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['daily:dailyupdate:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dailyupdateList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="是否有其他注意事项" align="center" prop="id" />
      <el-table-column label="今日日期" align="center" prop="todayDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.todayDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="是否在校" align="center" prop="onCampus" :formatter="onCampusFormat" />
      <el-table-column label="所在区域" align="center" prop="currentDistrict" :formatter="currentDistrictFormat" />
      <el-table-column label="所在地点" align="center" prop="currentLocation" />
      <el-table-column label="体温范围" align="center" prop="temperature" :formatter="temperatureFormat" />
      <el-table-column label="是否发烧咳嗽乏力" align="center" prop="feeling" :formatter="feelingFormat" />
      <el-table-column label="是否接触中高风险地区人员" align="center" prop="contact1" :formatter="contact1Format" />
      <el-table-column label="是否接触疑似确诊人员" align="center" prop="contact2" :formatter="contact2Format" />
      <el-table-column label="是否处于隔离期" align="center" prop="isolate" :formatter="isolateFormat" />
      <el-table-column label="是否有其他注意事项" align="center" prop="other" :formatter="otherFormat" />
      <el-table-column label="其他注意事项" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['daily:dailyupdate:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['daily:dailyupdate:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改每日上报对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="今日日期" prop="todayDate">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.todayDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择今日日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="学号" prop="studentNo">
          <el-input v-model="form.studentNo" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="是否在校">
          <el-radio-group v-model="form.onCampus">
            <el-radio
              v-for="dict in onCampusOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="所在区域">
          <el-radio-group v-model="form.currentDistrict">
            <el-radio
              v-for="dict in currentDistrictOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="所在地点" prop="currentLocation">
          <el-input v-model="form.currentLocation" placeholder="请输入所在地点" />
        </el-form-item>
        <el-form-item label="体温范围">
          <el-radio-group v-model="form.temperature">
            <el-radio
              v-for="dict in temperatureOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否发烧咳嗽乏力">
          <el-radio-group v-model="form.feeling">
            <el-radio
              v-for="dict in feelingOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否接触中高风险地区人员">
          <el-radio-group v-model="form.contact1">
            <el-radio
              v-for="dict in contact1Options"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否接触疑似确诊人员">
          <el-radio-group v-model="form.contact2">
            <el-radio
              v-for="dict in contact2Options"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否处于隔离期">
          <el-radio-group v-model="form.isolate">
            <el-radio
              v-for="dict in isolateOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否有其他注意事项">
          <el-radio-group v-model="form.other">
            <el-radio
              v-for="dict in otherOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="其他注意事项" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDailyupdate, getDailyupdate, delDailyupdate, addDailyupdate, updateDailyupdate } from "@/api/daily/dailyupdate";

export default {
  name: "Dailyupdate",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 每日上报表格数据
      dailyupdateList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否在校字典
      onCampusOptions: [],
      // 所在区域字典
      currentDistrictOptions: [],
      // 体温范围字典
      temperatureOptions: [],
      // 是否发烧咳嗽乏力字典
      feelingOptions: [],
      // 是否接触中高风险地区人员字典
      contact1Options: [],
      // 是否接触疑似确诊人员字典
      contact2Options: [],
      // 是否处于隔离期字典
      isolateOptions: [],
      // 是否有其他注意事项字典
      otherOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        todayDate: null,
        studentNo: null,
        onCampus: null,
        currentDistrict: null,
        currentLocation: null,
        temperature: null,
        feeling: null,
        contact1: null,
        contact2: null,
        isolate: null,
        other: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("fdu_on_campus").then(response => {
      this.onCampusOptions = response.data;
    });
    this.getDicts("fdu_current_district").then(response => {
      this.currentDistrictOptions = response.data;
    });
    this.getDicts("fdu_temperature").then(response => {
      this.temperatureOptions = response.data;
    });
    this.getDicts("fdu_feeling").then(response => {
      this.feelingOptions = response.data;
    });
    this.getDicts("fdu_contact1").then(response => {
      this.contact1Options = response.data;
    });
    this.getDicts("fdu_contact2").then(response => {
      this.contact2Options = response.data;
    });
    this.getDicts("fdu_isolate").then(response => {
      this.isolateOptions = response.data;
    });
    this.getDicts("fdu_other").then(response => {
      this.otherOptions = response.data;
    });
  },
  methods: {
    /** 查询每日上报列表 */
    getList() {
      this.loading = true;
      listDailyupdate(this.queryParams).then(response => {
        this.dailyupdateList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 是否在校字典翻译
    onCampusFormat(row, column) {
      return this.selectDictLabel(this.onCampusOptions, row.onCampus);
    },
    // 所在区域字典翻译
    currentDistrictFormat(row, column) {
      return this.selectDictLabel(this.currentDistrictOptions, row.currentDistrict);
    },
    // 体温范围字典翻译
    temperatureFormat(row, column) {
      return this.selectDictLabel(this.temperatureOptions, row.temperature);
    },
    // 是否发烧咳嗽乏力字典翻译
    feelingFormat(row, column) {
      return this.selectDictLabel(this.feelingOptions, row.feeling);
    },
    // 是否接触中高风险地区人员字典翻译
    contact1Format(row, column) {
      return this.selectDictLabel(this.contact1Options, row.contact1);
    },
    // 是否接触疑似确诊人员字典翻译
    contact2Format(row, column) {
      return this.selectDictLabel(this.contact2Options, row.contact2);
    },
    // 是否处于隔离期字典翻译
    isolateFormat(row, column) {
      return this.selectDictLabel(this.isolateOptions, row.isolate);
    },
    // 是否有其他注意事项字典翻译
    otherFormat(row, column) {
      return this.selectDictLabel(this.otherOptions, row.other);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        todayDate: null,
        studentNo: null,
        onCampus: "0",
        currentDistrict: "0",
        currentLocation: null,
        temperature: "0",
        feeling: "0",
        contact1: "0",
        contact2: "0",
        isolate: "0",
        other: "0",
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加每日上报";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDailyupdate(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改每日上报";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDailyupdate(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDailyupdate(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除每日上报编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDailyupdate(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('daily/dailyupdate/export', {
        ...this.queryParams
      }, `daily_dailyupdate.xlsx`)
    }
  }
};
</script>