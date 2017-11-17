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
                    <th>
                        <input type="checkbox" class="check-box" id="checkAllBox"/>
                    </th>
                    <th>序号</th>
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
                    <h4 class="modal-title">新增员工</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="empInfoForm">
                        <div class="form-group">
                            <label for="empName" class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="empName" name="empName" placeholder="请输入姓名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱地址:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址">
                                <span class="help-block"></span>
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
                    <button type="button" class="btn btn-primary" id="save_emp_btn">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 编辑员工信息模态框 -->
    <div class="modal fade" id="editEmpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">编辑员工</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="editEmpInfoForm">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <p class="form-control-static" id="editEmpName"></p>
                            </div>
                            <input type="hidden" id="editEmpId" name="empId"/>
                        </div>
                        <div class="form-group">
                            <label for="editEmail" class="col-sm-2 control-label">邮箱地址:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="editEmail" name="email" placeholder="请输入邮箱地址">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="editMale" value="M" checked="checked"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="editFemale" value="F"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="editDId" class="col-sm-2 control-label">所属部门:</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="dId" id="editDId">

                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="edit_emp_btn">提交</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    /*window.onbeforeunload = function () {
        return "你确定要离开吗"
    };*/

    var totalRecords, currentPage;
    $(function () {
        toPage(1);

        $("#add_btn").click(function () {
            var $emInfoForm = $("#empInfoForm");
            reset_form($emInfoForm);
            getAllDeps($emInfoForm.find('select'));
            $("#addEmpModal").modal({
                backdrop: 'static'
            });
        });

        $("#save_emp_btn").click(function () {
            if(!validateForm()){
                return false;
            }
            if($(this).attr("ajax-va")==="fail"){
                return false;
            }
            $.ajax({
                url: "${ctxPath}/emp",
                type: "POST",
                data: $("#empInfoForm").serialize(),
                success: function (result) {
                    alert(result.msg);
                    $("#addEmpModal").modal("hide");
                    toPage(totalRecords);
                }
            })
        });

        $("#empName").blur(function () {
            $.ajax({
                url: "${ctxPath}/checkEmp",
                type: "POST",
                data: {"empName": $("#empName").val()},
                success: function (result) {
                    if (result.code === 200){
                        validStyle($("#empName"), "success", "");
                        $("#save_emp_btn").attr("ajax-va", "success");
                    }else {
                        validStyle($("#empName"), "fail", "该用户名已经存在,请重新输入");
                        $("#save_emp_btn").attr("ajax-va", "fail");
                    }
                }
            })
        });

        $("#checkAllBox").click(function () {
            $("#table").find(".check-item").prop("checked", $("#checkAllBox").prop("checked"));
        });

        $(document).on("click", ".check-item", function () {
            var flag = $(".check-item:checked").length === $(".check-item").length;
            $("#checkAllBox").prop("checked", flag);
        });

        $("#del_btn").click(function () {
            var names = '';
            var ids = '';
            if ($(".check-item:checked").length === 0){
                alert("请先选择员工！");
                return false;
            }else{
                $.each($(".check-item"), function () {
                    if ($(this).prop("checked")){
                        ids = ids + $(this).parent().next().text() + ",";
                        names = names + $(this).parent().next().next().text() + ",";
                    }
                });
            }
            ids = ids.substring(0, ids.length-1);
            names = names.substring(0, names.length-1);
            delEmp(ids, names);
        })
    });

    $("#edit_emp_btn").click(function () {
        if (vlidateEmail($("#editEmail"))){
            $.ajax({
                url:"${ctxPath}/emp",
                type:"PUT",
                data:$("#editEmpInfoForm").serialize(),
                success:function (result) {
                    alert(result.msg);
                    $("#editEmpModal").modal('hide');
                    toPage(currentPage);
                }
            })
        }
    });

    function vlidateEmail(elem) {
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(elem.val())){
            validStyle(elem, "fail", "请输入正确的邮箱格式");
            return false;
        }else {
            validStyle(elem, "success", "");
            return true;
        }
    }

    function toPage(pageNum) {
        $.ajax({
            url: "${ctxPath}/emps",
            type: "GET",
            data: "pageNumber=" + pageNum,
            success: function (result) {
                $("#checkAllBox").attr("checked", false);
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
            var checkBoxTd = $("<td><input type='checkbox' class='check-item'></td>");
            var empIdTd = $("<td></td>").append(emp.empId);
            var empNameTd = $("<td></td>").append(emp.empName);
            var genderTd = $("<td></td>").append(emp.gender === "M" ? "男" : "女");
            var emailTd = $("<td></td>").append(emp.email);
            var departmentTd = $("<td></td>").append(emp.department.deptName);
            var editBtn = $("<Button></Button>").addClass("btn btn-info btn-sm").attr("onclick", "openEditModal("+ emp.empId +");")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑"));
            var delBtn = $("<Button></Button>").addClass("btn btn-danger btn-sm").attr("onclick", "delEmp("+ emp.empId + ",'" + emp.empName +"');")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash").append("删除"));
            var editTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

            $("<tr></tr>").append(checkBoxTd)
                .append(empIdTd)
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
        totalRecords = pageInfo.total;
        currentPage = pageInfo.pageNum;
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

    function getAllDeps(elem) {
        $.ajax({
            url: "${ctxPath}/getAllDeps",
            type: "GET",
            async: false,
            success: function (result) {
                $.each(result, function () {
                    var option = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    option.appendTo(elem);
                })
            }
        })
    }

    function getEmp(empId) {
        $.ajax({
            url:"${ctxPath}/emp/"+empId,
            type:"GET",
            async:false,
            success:function (result) {
                var emp = result.map.emp;
                $("#editEmpId").val(emp.empId);
                $("#editEmpName").text(emp.empName);
                $("#editEmail").val(emp.email);
                $("#editEmpModal").find('input[name=gender]').val([emp.gender]);
                $("#editDId").val([emp.dId]);
            }
        })
    }

    function validateForm() {
        var $empName = $("#empName");
        var empName = $empName.val();
        var regEmpName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regEmpName.test(empName)){
            validStyle($empName, "fail", "请输入2~5个汉字或者3~16个字母和数字组合");
            return false;
        }else {
            validStyle($empName, "success", "");
        }
        var $email = $("#email");
        var email = $email.val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(email)){
            validStyle($email, "fail", "请输入正确的邮箱格式");
            return false;
        }else {
            validStyle($email, "success", "");
        }
        return true;
    }

    function validStyle(elem, status, msg) {
        elem.parent().removeClass("has-success has-error");
        if (status === "success"){
            elem.parent().addClass("has-success");
            elem.next().text("");
        }else if (status === "fail"){
            elem.parent().addClass("has-error");
            elem.next().text(msg);
        }
    }

    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
        $(ele).find('select').empty();
    }

    function openEditModal(empId) {
        $("#editEmpModal").modal({
            backdrop: 'static'
        });
        reset_form("#editEmpInfoForm");
        getAllDeps($("#editEmpInfoForm").find("select"));
        getEmp(empId);
    }

    function delEmp(empId, empName) {
        if (confirm("确定要删除员工["+ empName +"]吗？")){
            $.ajax({
                url:"${ctxPath}/emp/"+empId,
                type:"DELETE",
                success:function (result) {
                    toPage(currentPage);
                    alert(result.msg);
                    $("#checkAllBox").prop("checked", "");
                }
            })
        }
    }
</script>
</body>
</html>