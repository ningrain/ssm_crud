<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/resources/globle.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>员工列表</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <h1>SSM_CRUD</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" id="add_btn" class="btn btn-primary">新增</button>
            <button type="button" id="del_btn" class="btn btn-danger">删除</button>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table id="table" class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th></th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>电子邮件</th>
                    <th>所属部门</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6" id="page_info"></div>
        <div class="col-xs-6" id="page_nav"></div>
    </div>

    <!-- 新增员工信息模态框 -->
    <div class="modal fade" id="addEmpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">新增员工</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="empName" class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="empName" name="empName" placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱地址:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="male" value="M" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="female" value="F"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dId" class="col-sm-2 control-label">所属部门:</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="dId" id="dId">

                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(function () {
        toPage(1);

        $("#add_btn").click(function () {
            getAllDeps();
            $("#addEmpModal").modal({
                backdrop: 'static'
            });
        })
    });

    function toPage(pageNum) {
        $.ajax({
            url: "${ctxPath}/emps",
            type: "GET",
            data: "pageNumber=" + pageNum,
            success: function (result) {
                build_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }

    function build_table(result) {
        // $("#table tbody") IDEA提示效率低
        $("#table").find('tbody').empty();
        var emps = result.map.pageInfo.list;
        $.each(emps, function (index, emp) {
            var empIdTd = $("<td></td>").append(emp.empId);
            var empNameTd = $("<td></td>").append(emp.empName);
            var genderTd = $("<td></td>").append(emp.gender === "M" ? "男" : "女");
            var emailTd = $("<td></td>").append(emp.email);
            var departmentTd = $("<td></td>").append(emp.department.deptName);
            var editBtn = $("<Button></Button>").addClass("btn btn-info btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑"));
            var delBtn = $("<Button></Button>").addClass("btn btn-danger btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash").append("删除"));
            var editTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

            $("<tr></tr>").append(empIdTd)
                .append(empNameTd)
                .append(genderTd)
                .append(emailTd)
                .append(departmentTd)
                .append(editTd)
                .appendTo("#table tbody");
        });
    }

    function build_page_info(result) {
        var pageinfo = $("#page_info");
        pageinfo.empty();
        var pageInfo = result.map.pageInfo;
        pageinfo.append("<div>当前是第" + pageInfo.pageNum + "页, 总计" +
            pageInfo.pages + "页, 总共" + pageInfo.total + "条记录</div>");
    }

    function build_page_nav(result) {
        $("#page_nav").empty();
        var pageInfo = result.map.pageInfo;
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a>首页</a>").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("<span>&laquo;</span>"));
        if (pageInfo.hasPreviousPage) {
            firstPageLi.click(function () {
                toPage(1);
            });
            prePageLi.click(function () {
                toPage(pageInfo.pageNum - 1);
            });
        } else {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }
        ul.append(firstPageLi).append(prePageLi);

        $.each(pageInfo.navigatepageNums, function (index, pageNum) {
            var pageNumLi = $("<li></li>").append($("<a>" + pageNum + "</a>").attr("href", "#"));
            if (pageInfo.pageNum === pageNum) {
                pageNumLi.addClass("active");
            }
            pageNumLi.click(function () {
                toPage(pageNum);
            });
            ul.append(pageNumLi);
        });

        var nextPageLi = $("<li></li>").append($("<a></a>").attr("href", "#").append("<span>&raquo;</span>"));
        var lastPageLi = $("<li></li>").append($("<a>末页</a>").attr("href", "#"));

        if (pageInfo.hasNextPage) {
            nextPageLi.click(function () {
                toPage(pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                toPage(pageInfo.pages);
            });
        } else {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }

        ul.append(nextPageLi).append(lastPageLi);
        $("<nav></nav>").append(ul).appendTo("#page_nav");
    }

    function getAllDeps() {
        $.ajax({
            url: "${ctxPath}/getAllDeps",
            type: "GET",
            success: function (result) {
                $.each(result, function () {
                    var option = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    option.appendTo("#dId");
                })
            }
        })
    }
</script>
</body>
</html>