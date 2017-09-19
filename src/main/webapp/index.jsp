<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/resources/globle.jsp"%>
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
            <button type="button" class="btn btn-primary">新增</button>
            <button type="button" class="btn btn-danger">删除</button>
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
        <div class="col-xs-6">
            当前第页, 总计页, 总共条记录
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
       $.ajax({
           url:"${ctxPath}/emps",
           type:"GET",
           data:"pageNumber=1",
           success:function (result) {
               build_table(result);
           }
       });
    });

    function build_table(result){
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


        $("<tr></tr>");
    }

</script>
</body>
</html>