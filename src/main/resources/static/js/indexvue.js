
var zx_vue=new Vue({
    el: "#zx_box",
    data: {
        zxall_1:[
        ]
    },mounted(){
        _this=this
        axios.get('/getallnews')
            .then(function (response) {//是返回的所有信息
                console.log(response);
                console.log(response.data)
                _this.zxall_1=response.data
                //response.length
                for(var i=0;i<response.data.length;i++)
                {
                    console.log(response.data[i].name)
                }
            })
            .catch(function (error) {
                console.log(error);

            });
    }
});
