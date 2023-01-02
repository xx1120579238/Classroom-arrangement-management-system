<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教室编号" prop="cId">
        <el-input
          v-model="queryParams.cId"
          placeholder="请输入教室编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教室名称" prop="cName">
        <el-input
          v-model="queryParams.cName"
          placeholder="请输入教室名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程编号" prop="crNo">
        <el-input
          v-model="queryParams.crNo"
          placeholder="请输入课程编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教师姓名" prop="crTeachername">
        <el-input
          v-model="queryParams.crTeachername"
          placeholder="请输入教师姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期" prop="aWeek">
        <el-input
          v-model="queryParams.aWeek"
          placeholder="请输入星期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="时段" prop="aTime">
        <el-input
          v-model="queryParams.aTime"
          placeholder="请输入时段"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:arrange:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:arrange:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:arrange:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:arrange:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="arrangeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="上课编号" align="center" prop="aId" />
      <el-table-column label="教室编号" align="center" prop="cId" />
      <el-table-column label="教室名称" align="center" prop="cName" />
      <el-table-column label="课程编号" align="center" prop="crNo" />
      <el-table-column label="教师姓名" align="center" prop="crTeachername" />
      <el-table-column label="星期" align="center" prop="aWeek" />
      <el-table-column label="时段" align="center" prop="aTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:arrange:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:arrange:remove']"
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

    <!-- 添加或修改安排对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教室编号" prop="cId">
          <el-input v-model="form.cId" placeholder="请输入教室编号" />
        </el-form-item>
        <el-form-item label="教室名称" prop="cName">
          <el-input v-model="form.cName" placeholder="请输入教室名称" />
        </el-form-item>
        <el-form-item label="课程编号" prop="crNo">
          <el-input v-model="form.crNo" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="教师姓名" prop="crTeachername">
          <el-input v-model="form.crTeachername" placeholder="请输入教师姓名" />
        </el-form-item>
        <el-form-item label="星期" prop="aWeek">
          <el-input v-model="form.aWeek" placeholder="请输入星期" />
        </el-form-item>
        <el-form-item label="时段" prop="aTime">
          <el-input v-model="form.aTime" placeholder="请输入时段" />
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
import { listArrange, getArrange, delArrange, addArrange, updateArrange } from "@/api/system/arrange";

export default {
  name: "Arrange",
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
      // 安排表格数据
      arrangeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cId: null,
        cName: null,
        crNo: null,
        crTeachername: null,
        aWeek: null,
        aTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        cId: [
          { required: true, message: "教室编号不能为空", trigger: "blur" }
        ],
        cName: [
          { required: true, message: "教室名称不能为空", trigger: "blur" }
        ],
        crNo: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
        crTeachername: [
          { required: true, message: "教师姓名不能为空", trigger: "blur" }
        ],
        aWeek: [
          { required: true, message: "星期不能为空", trigger: "blur" }
        ],
        aTime: [
          { required: true, message: "时段不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询安排列表 */
    getList() {
      this.loading = true;
      listArrange(this.queryParams).then(response => {
        this.arrangeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        aId: null,
        cId: null,
        cName: null,
        crNo: null,
        crTeachername: null,
        aWeek: null,
        aTime: null
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
      this.ids = selection.map(item => item.aId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加安排";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const aId = row.aId || this.ids
      getArrange(aId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改安排";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.aId != null) {
            updateArrange(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArrange(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const aIds = row.aId || this.ids;
      this.$modal.confirm('是否确认删除安排编号为"' + aIds + '"的数据项？').then(function() {
        return delArrange(aIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/arrange/export', {
        ...this.queryParams
      }, `arrange_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
