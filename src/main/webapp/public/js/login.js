$(function(){
    $('#confirm').on('click',function(){
        var username = $('#username').val();
        var password = $('#password').val();
        var data = {
            username: username,
            password: password
        };
        var basePath = $('#basePath').val();
        $.ajax({
            url: basePath + '/user/login',
            type: 'POST',
            dataType: 'json',
            data: data,
            success: function(data){
                console.log(data);
                if(data.code == 0){
                    layer.msg(data.ext);
                    setTimeout(function(){
                        window.location.href = basePath + '/user/success';
                    },1000);
                }else{
                    layer.msg(data.ext);
                }
            },
            error: function(xhr){
                console.log(data);
            }
        });
    });

});