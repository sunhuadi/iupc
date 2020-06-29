
var zx_vue=new Vue({
    el: "#zx_box",
    data: {
        zxall:[
            {
                image:"image/zixun/test1.jpg",
                title:"震惊！这条裙子美爆了，现在买还送洗脸盆！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-22",
            },
            {
                image:"image/zixun/test2.jpg",
                title:"震惊！这条裙子美爆了！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-23",
            },
            {
                image:"image/zixun/test3.jpg",
                title:"618大促！党妹倾情推荐！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-23",
            },
        ],
        zxall_1:[
            {
                image:"image/zixun/test1.jpg",
                title:"震惊！这条裙子美爆了，现在买还送洗脸盆！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-22",
            },
            {
                image:"image/zixun/test2.jpg",
                title:"震惊！这条裙子美爆了！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-23",
            },
            {
                image:"image/zixun/test3.jpg",
                title:"618大促！党妹倾情推荐！",
                content:
                    "这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。这是一条测试资讯，它的内容都是废话。",
                time:"2020-6-23",
            },
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
