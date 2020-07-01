
var zx_vue=new Vue({
    el: "#zx_box",
    data: {
        zxall:[],
    },mounted(){
        _this=this
        axios.get('/getallnews')
            .then(function (response) {//是返回的所有信息
                console.log(response);
                console.log(response.data)
                _this.zxall=response.data
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
