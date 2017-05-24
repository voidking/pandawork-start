$(function(){
    function logout(){
        var basePath = $('#basePath').val();
        $.ajax({
            url: basePath + '/admin/logout',
            type: 'POST',
            dataType: 'json',
            data: {},
            success: function(data){
                console.log(data);
                if(data.code == 0){
                    window.location.href = basePath + '/admin/login';
                }
            },
            error: function(xhr){
                console.log(data);
            }
        });
    }

    $('#logout').click(function(){
        layer.confirm('确认退出？', {
            btn: ['是的','取消'] //按钮
        }, function(){
            logout();
        }, function(){

        });
        
    });
});