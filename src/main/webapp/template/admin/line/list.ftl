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
    <link href="${basePath}/public/css/admin/linelist.css" rel="stylesheet">
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
                <li><a href="/admin/user/list">用户管理</a></li>
                <li class="active"><a href="/admin/line/list">管理路线</a></li>
                <li><a href="/admin/line/add">添加路线</a></li>

            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">路线管理</h1>
            <div class="search input-group">
                <input type="text" id="key" class="form-control" placeholder="输入路线或首尾站名">
                <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="search">搜索</button>
          </span>
            </div>

            <h2 class="sub-header">路线列表</h2>
            <div class="table-responsive">
                <table class="user-table table table-striped">
                    <thead>
                    <tr>
                        <th>路线简称</th>
                        <th>路线全称</th>
                        <th>首站</th>
                        <th>尾站</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody class="line-tbody">
                    <#list lineList as line>
                    <tr data-id="${line.id}">
                        <td class="busName">${line.busName}</td>
                        <td class="fullName">${line.fullName}</td>
                        <td class="firstStop">${line.firstStop?default('')}</td>
                        <td class="lastStop">${line.lastStop?default('')}</td>
                        <td>
                            <button class="edit btn btn-sm btn-info">修改</button>
                            <button class="delete btn btn-sm btn-danger">删除</button>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<input id="basePath" type="hidden" value="${basePath}">
<div class="pane-hide" style="display: none;">
    <div class="table-responsive">
        <form action="" class="line-form form-horizontal" role="form">
            <input id="line-id" type="hidden">
            <div class="form-group">
                <label for="bus-name" class="col-sm-2 control-label">路线简称</label>
                <div class="col-sm-10">
                    <input type="text" id="bus-name" name="busName" class="bus-name form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="full-name" class="col-sm-2 control-label">路线全称</label>
                <div class="col-sm-10">
                    <input type="text" id="full-name" name="fullName" class="full-name form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="first-stop" class="col-sm-2 control-label">首站</label>
                <div class="col-sm-10">
                    <input type="text" id="first-stop" name="firstStop" class="first-stop form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="last-stop" class="col-sm-2 control-label">尾站</label>
                <div class="col-sm-10">
                    <input type="text" id="last-stop" name="lastStop" class="last-stop form-control">
                </div>
            </div>
            <button type="submit" class="btn btn-default btn-primary">确认</button>
            <span class="cancel btn btn-default">取消</span>
        </form>
    </div>
</div>

<script id="line-template" type="text/html">
    {{each lineList as line}}
    <tr data-id="{{line.id}}">
        <td class="busName">{{line.busName}}</td>
        <td class="fullName">{{line.fullName}}</td>
        <td class="firstStop">{{line.firstStop}}</td>
        <td class="lastStop">{{line.lastStop}}</td>
        <td>
            <button class="edit btn btn-sm btn-info">修改</button>
            <button class="delete btn btn-sm btn-danger">删除</button>
        </td>
    </tr>
    {{/each}}
</script>
<script src="${basePath}/public/lib/jquery/jquery.min.js"></script>
<script src="${basePath}/public/lib/art-template/dist/template.js"></script>
<script src="${basePath}/public/lib/layer/src/layer.js"></script>
<script src="${basePath}/public/js/admin/adminlogout.js"></script>
<script>
$(function(){
    $('.line-tbody').on('click','.edit',function(){
        $tr = $(this).parents('tr');
        var id = $tr.attr('data-id');
        var busName = $tr.children('td:eq(0)').html();
        var fullName = $tr.children('td:eq(1)').html();
        var firstStop = $tr.children('td:eq(2)').html();
        var lastStop = $tr.children('td:eq(3)').html();
        $('#line-id').val(id);
        $('#bus-name').val(busName);
        $('#full-name').val(fullName);
        $('#first-stop').val(firstStop);
        $('#last-stop').val(lastStop);
        var index = layer.open({
            type: 1,
            title: '修改路线',
            skin: 'layui-layer-rim', //加上边框
            area: ['600px', '305px'], //宽高
            content: $('.pane-hide')
        });
        $('.cancel').unbind().click(function(){
            layer.close(index);
        });
    });


    $('.line-tbody').on('click','.delete',function(){
        $tr = $(this).parents('tr');
        var id = $tr.attr('data-id');
        var data = {
            id: id
        };
        var index = layer.confirm('确认删除？', {
            btn: ['是的','取消'] //按钮
        }, function(){
            var basePath = $('#basePath').val();
            $.ajax({
                url: basePath + '/admin/line/del',
                type: 'POST',
                dataType: 'json',
                data: data,
                success: function(data){
                    console.log(data);
                    if(data.code == 0){
                        layer.close(index);
                        $tr.remove();
                        layer.msg('删除成功！');
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

    $('#search').click(function(event) {
        var basePath = $('#basePath').val();
        var key = $('#key').val();
        $.ajax({
            url: basePath+'/admin/line/search',
            type: 'POST',
            dataType: 'json',
            data: {key: key},
            success: function(data){
                console.log(data);
                var html = template('line-template', data);
                $('.line-tbody').html(html);
            },
            error: function(xhr){
                console.log(xhr);
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

    $('.line-form').submit(function(event) {
        event.preventDefault();
        var data = {
            id: $('#line-id').val(),
            busName: $('#bus-name').val(),
            fullName: $('#full-name').val(),
            firstStop: $('#first-stop').val(),
            lastStop: $('#last-stop').val()
        }
        var basePath = $('#basePath').val();
        $.ajax({
            url: basePath+'/admin/line/update',
            type: 'POST',
            dataType: 'json',
            data: data,
            success: function(data){
                console.log(data);
                if(data.code == 0){
                    layer.msg('修改成功');
                    setTimeout(function(){
                        window.location.href = basePath+'/admin/line/list';
                    },1500);
                }else{
                    layer.msg(data.ext);
                }
            },
            error: function(xhr){
                console.log(xhr);
            }
        });

    });
});
</script>
</body>
</html>
