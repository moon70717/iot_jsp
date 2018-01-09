<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=rootPath%>/ui/css/list.css" />

<body>
	<jsp:include page="/WEB-INF/view/common/header.jspf" flush="false" />
	<br>
	<style>
#table {
	margin-top: 100px;
}
</style>
	<div class="container">
		<div id="table" class="table-editable">
			<div class="col col-xs-6">
				<h3 class="panel-title">Class List</h3>
			</div>
			<div class="col col-xs-6 text-right">
				<input type="text" class="input">
				<button type="button" class="btn btn-sm btn-primary btn-create">검색</button>
			</div>
			<table id="grid1" data-key="ciNo" class="table">
				<thead>
					<tr>
						<th class="text-center" data-field="ciNo,ro">번호</th>
						<th class="text-center" data-field="ciName,txt">이름</th>
						<th class="text-center" data-field="ciDesc,txt">설명</th>
						<th class="text-center" data-field="BTN"><em
							class="glyphicon glyphicon-asterisk"></em></th>
					</tr>
				</thead>
				<tbody id="result_tb">
				</tbody>
				<tr>
				<tr>
					<!-- insert 받는부분 -->
					<th contenteditable="false">반 추가</th>
					<th contenteditable="true" placeholder="이름을 입력하세요"
						id="insertCiName"></th>
					<th contenteditable="true" placeholder="설명을 입력하세요"
						id="insertCiDesc"></th>
					<th><a class="btn btn-default" onclick="insert()"><em
							class="glyphicon glyphicon-plus"></em> </a></th>
				</tr>
			</table>

		</div>
	</div>
</body>
<script>
        function insert() {
        	var ciName = $("#insertCiName").text().trim();
            var ciDesc = $("#insertCiDesc").text().trim();
            if(ciName!=null){
            	if(ciDesc!=null){
            		var param = {
                            ciName: ciName,
                            ciDesc: ciDesc
                        };
                        param = "param=" + JSON.stringify(param);
                            $.ajax({
                                url: '/class/insert',
                                data: param,
                                dataType: 'json',
                                type: 'post',
                                success: function(res) {
                                    alert(res.msg);
                                    if (res.result == 'ok') {
                                        location.reload();
                                    }
                                },
                                error: function(xhr, status, error) {
                                    alert("error");
                                }
                            });
            	}else{
            		alert("설명을 추가하세요");
            	}
            }else{
            	alert("이름을 추가하세요");
            }
        }

        function deleteClass(ciNo) {
            var isDelete = confirm(ciNo + "를 삭제하시겠습니까?");
            var param = "ciNo=" + ciNo;
            if (isDelete) {
                $.ajax({
                    url: '/class/delete',
                    data: param,
                    dataType: 'json',
                    type: 'post',
                    success: function(res) {
                        alert(res.msg);
                        if (res.result == 'ok') {
                            location.reload();
                        }
                    },
                    error: function(xhr, status, error) {

                    }
                });
            }
        }

        function updateClass(ciNo) {
            var ciName = $("#ciName" + ciNo).text().trim();
            var ciDesc = $("#ciDesc" + ciNo).text().trim();
            var param = {
                ciName: ciName,
                ciDesc: ciDesc,
                ciNo: ciNo
            };
            param = "param=" + JSON.stringify(param);

            var isUpdate = confirm(ciNo + "를 수정하시겠습니까?");
            if (isUpdate) {
                $.ajax({
                    url: '/class/update',
                    data: param,
                    dataType: 'json',
                    type: 'post',
                    success: function(res) {
                        alert(res.msg);
                        if (res.result == 'ok') {
                            location.reload();
                        }
                    },
                    error: function(xhr, status, error) {
                        alert("error");
                    }
                });
            }

        }

        var colsInfo = [];
        $(document).ready(function() {
            var colList = $("#grid1 th[data-field]");
            for (var i = 0; i < colList.length; i++) {
                colsInfo.push(colList[i].getAttribute("data-field"));
            }

            var keyCol = $("#grid1").attr("data-key");


            $.ajax({
                url: '/class/list',
                type: 'get',
                success: function(res) {
                    var list = JSON.parse(res);
                    var str = "";
                    for (var uc of list) {
                        var key = uc[keyCol];
                        str += "<tr>";
                        for (var field of colsInfo) { /* <td contenteditable="false">3</td> */
                            str += '<td contenteditable="';
                            if (field == "BTN") {
                                str += 'false"><a class="btn btn-default" onclick="updateClass(' + key + ')"><em class="glyphicon glyphicon-refresh"></em></a>';
                                str += '<a class="btn btn-danger" onclick="deleteClass(' + key + ')"><em class="glyphicon glyphicon-trash"></em></a>';
                            } else {
                                var colName = field.split(",")[0];
                                var colType = field.split(",")[1];
                                if (colType == "ro") {
                                    str += 'false">' + uc[colName];
                                } else {
                                    str += 'true" id="' + colName + key + '" >' + uc[colName];
                                }
                            }
                            str += "</td>";
                        }
                        str += "</tr>";
                    }
                    /* str+='<tr>'+
                    	'<th contenteditable="false">반 추가</th>'+
    					'<th contenteditable="true" placeholder="이름을 입력하세요"></th>'+
    					'<th contenteditable="true" placeholder="설명을 입력하세요"></th>'+
    					'<th contenteditable="false"><em class="glyphicon glyphicon-plus"></em></th></tr>'; */

                    $("#result_tb").html(str);
                },
                error: function(xhr, status, error) {

                }
            });

        });

    </script>

</html>
