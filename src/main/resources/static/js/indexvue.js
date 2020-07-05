
var zx_vue=new Vue({
    el: "#zx_box",
    data: {
        zxall:[],
    },mounted(){
        _this=this
        axios.post('/command',{variable:"0"})
            .then(function (response) {//是返回的所有信息
               // console.log(response);
                //console.log(response.data)
               // _this.zxall=response.data[0]
                //console.log(_this.zxall)
                for(var i=0;i<response.data.length;i++)
                {
                   _this.zxall= _this.zxall.concat(response.data[i])
                  //  _this.zxall[i]=response.data[i]

                }
               console.log(_this.zxall)
            })
            .catch(function (error) {
                console.log(error);

            });
    }
});

var zx_vue1=new Vue({
    el: "#zx_box1",
    data: {
        zxall:[],
    },mounted(){
        __this=this
        axios.post('/command',{variable:"1"})
            .then(function (response) {//是返回的所有信息
                // console.log(response);
                //console.log(response.data)
                // _this.zxall=response.data[0]
               // console.log(_this.zxall)
                for(var i=0;i<response.data.length;i++)
                {
                    __this.zxall= __this.zxall.concat(response.data[i])
                    //  _this.zxall[i]=response.data[i]

                }
                console.log(__this.zxall)
            })
            .catch(function (error) {
                console.log(error);

            });
    }
});

