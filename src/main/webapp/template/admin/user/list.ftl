<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>后台管理</title>
    
  <link href="${basePath}/public/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${basePath}/public/css/admin/dashboard.css" rel="stylesheet">
</head>

<body>

  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">后台管理</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="javascript:void(0);">${admin.username}</a></li>
          <li><a href="javascript:void(0);" id="logout">退出</a></li>
        </ul>
        <!--
        <form class="navbar-form navbar-right">
          <input type="text" class="form-control" placeholder="Search...">
        </form>
        -->
      </div>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active"><a href="/admin/user/list">用户管理</a></li>
          <li><a href="/admin/line/list">管理路线</a></li>
          <li><a href="/admin/line/add">添加路线</a></li>

        </ul>
      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="page-header">用户管理</h1>
        <div class="search input-group">
          <input type="text" id="key" class="form-control" placeholder="输入关键词">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="search">搜索</button>
          </span>
        </div>
        <h2 class="sub-header">用户信息</h2>
        <div class="table-responsive">
          <table class="user-table table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>手机号</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody class="user-tbody">
              <#list userList as user>
              <tr data-id="${user.id}">
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email?default('')}</td>
                <td>${user.tel?default('')}</td>
                <td><button class="delete">删除</button></td>
              </tr>
              </#list>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

<input id="basePath" type="hidden" value="${basePath}">
<script type="text/html" id="user-template">
  {{each userList as user}}
  <tr data-id="{{user.id}}">
    <td>{{user.id}}</td>
    <td>{{user.username}}</td>
    <td>{{user.email}}</td>
    <td>{{user.tel}}</td>
    <td><button class="delete">删除</button></td>
  </tr>
  {{/each}}
</script>
<script src="${basePath}/public/lib/jquery/jquery.min.js"></script>
<script src="${basePath}/public/lib/art-template/dist/template.js"></script> 
<script src="${basePath}/public/lib/layer/src/layer.js"></script>
<script src="${basePath}/public/js/admin/adminlogout.js"></script>
<script>
$(function(){
  $('.user-table').on('click','.delete',function(){
    var $that = $(this);
    layer.confirm('确认删除用户', {
      btn: ['确定','取消'] //按钮
    }, function(){
      var $tr = $that.parents('tr');
      var userId = $tr.attr('data-id');
      var basePath = $('#basePath').val();
      $.ajax({
          url: basePath + '/admin/user/del',
          type: 'POST',
          dataType: 'json',
          data: {userId: userId},
          success: function(data){
              console.log(data);
              if(data.code == 0){
                  layer.msg('删除成功！');
                  $tr.remove();
              }else{
                  layer.msg(data.ext);
              }
          },
          error: function(xhr){
              console.log(data);
          }
      });
    }, function(){

    });
    
  });

  $('#search').on('click',function(){
    var key = $('#key').val();
    var basePath = $('#basePath').val();
    $.ajax({
        url: basePath + '/admin/user/search',
        type: 'POST',
        dataType: 'json',
        data: {key: key},
        success: function(data){
            console.log(data);
            if(data.code == 0){
              var html = template('user-template',data);
                $('.user-tbody').html(html);
            }
        },
        error: function(xhr){
            console.log(data);
        }
    });
  });

  $('#key').keypress(function(event) {
    var key = event.which;
    //console.log(key);
    if(key == 13){
        $('#search').trigger('click');
    }
  });
});
</script>
</body>
</html>
