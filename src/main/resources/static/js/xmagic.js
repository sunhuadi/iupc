/*
 * 侧边栏
 * 导航栏
 */
var tch=0;
var tchstp=7;
var maxtch=0;
var whichone=0;
var tourist_vue= new Vue(
    {
        el:"#tourist",
        data:{
            tli:[
                {content:"三坑笔记",
                    isshow:false,
                    slcontent:[
                        {name:"汉服",link:"/all_notes_hf"},
                        {name:"Lolita",link:"/all_notes_lolita"},
                        {name:"JK",link:"/all_notes_jk"},
                        {name:"全部",link:"/all_notes"},
                    ]
                },
                {content:"查看资讯",
                    isshow:false,
                    slcontent:[
                        {name:"汉服",link:"/all_news_hf"},
                        {name:"Lolita",link:"/all_news_lolita"},
                        {name:"JK",link:"/all_news_jk"},
                        {name:"全部",link:"/all_news"},
                    ]
                },
                {content:"我的收藏",
                    isshow:false,
                    slcontent:[
                        {name:"资讯",link:"/favorite_news"},
                        {name:"笔记",link:"/favorite_note"},
                        {name:"商品",link:"/favorite_goods"},
                    ]
                },
                {content:"笔记发布",
                    isshow:false,
                    slcontent:[
                        {name:"发布笔记",link:""},
                        {name:"已发布",link:""},
                    ]
                },

                {content:"我的店铺",
                    isshow:false,
                    slcontent:[
                        {name:"进入店铺",link:""},
                        {name:"店铺管理",link:""},
                    ]
                },
                {content:"店家专属",
                    isshow:false,
                    slcontent:[
                        {name:"商品上新",link:"/upload_good"},
                        {name:"资讯发布",link:"/upload_news"},
                        {name:"讨论区",link:""},
                    ]
                },
                {content:"我的信息",
                    isshow:false,
                    slcontent:[
                        {name:"我的消息",link:""},
                        {name:"账号信息",link:""},
                    ]
                },
                {content:"敬请期待",
                },
            ]
        },
        methods:{
            showit:function (which) {
                for(i=0;i<this.tli.length;i++){
                    if(i!=which)
                        this.tli[i].isshow=false;
                }
                maxtch=this.tli[which].slcontent.length*33+5;
                tch=0;
                whichone=which;
                this.tli[which].isshow=!(this.tli[which].isshow);
            },
            goto(link){
                window.location.href=link;
                console.log("goto"+link);
            }
        }
    },
    setInterval(function () {
        var idname="showtlic";
        var a=document.getElementById(idname);
        tch+=tchstp;
        if(a!=null){
            if(tch>=maxtch)
                a.style.height=maxtch+'px';
            else
                a.style.height=tch+'px';
        }
    },20));
/*
 * 搜索
 */
var snsh;
var search_vue= new Vue(
    {
        el:"#header_search",
        data:{
            svalue:"",
            history_search:[],
            filtersearch:[],
            hshow:false,
            stopunshow:false,
        },
        methods:{
            saveit:function () {
                this.svalue=this.svalue.trim();
                if(this.svalue=="")
                {
                    alert("搜索内容不能为空");
                }
                else{
                    this.history_search.unshift(this.svalue);
                    for(i=1;i<this.history_search.length;i++)
                    {
                        if(this.history_search[i]==this.svalue)
                        {
                            this.history_search.splice(i,1);
                            break;
                        }
                    }
                    sessionStorage.setItem("history_search",JSON.stringify(this.history_search));
                    sessionStorage.setItem("search_keyword",this.svalue);
                    window.location.href="/search_result";
                }
            },
            deleteit(which)
            {
                this.hshow=true;
                this.history_search.splice(which,1);
                sessionStorage.setItem("history_search",JSON.stringify(this.history_search));
            },
            doshowit()
            {
                snhs=JSON.parse(sessionStorage.getItem("history_search"));
                if(snhs!=null){
                    this.history_search=snhs;
                    if(this.history_search.length>0)
                        this.hshow=true;
                }
            },
            unshowit(){
                if(!this.stopunshow)
                    this.hshow=false;
            },
        }
    }
);
/*
 *news 组件
 * myclassname  设置class
 * news_title   设置标题
 * news_img     设置图片地址
 * news_content 设置内容，当字数大于200时会截取到200
 * news_id      设置news的id，用于跳转
 * news_time    设置news发布时间
 */
Vue.component("news",{
    template:`
        <div :class="myclassname">
        <img class="zxi_pic" :src="news_img" />
        <img class="zxi_pic_fly" src="image/透明蓝色蝴蝶结.gif">
        <div class="zxi_text">
        <p class="zxi_title" @click="readthisnews" >{{ news_title }}</a></p>
        <p class="zxi_content">{{ shortifycontent }}</p>
        <p class="zxi_time" >{{ news_time }}</p>
       
        </div>
        </div>`,
    props:{
        news_title:String,
        news_id:String,
        news_time:String,
        news_img:String,
        news_content:String,
        myclassname:String,
    },
    computed:{
        shortifycontent(){
            if(this.news_content==null)
                return "无内容";
            if(this.news_content.length<=150)
                return this.news_content;
            else
                return this.news_content.slice(0,100)+"...";
        }

    },
    methods:{

        readthisnews()
        {
            sessionStorage.setItem("mynews_id",this.news_id);
            window.location.href="/zxck";
        }
    }
})
Vue.component("news_message",{
    template:`
        <div :class="myclassname">
        <img class="zxi_pic" :src="news_img" />
        <img class="zxi_pic_fly" src="image/透明蓝色蝴蝶结.gif">
        <div class="zxi_text">
        <p class="zxi_title" @click="readthisnews" >{{ news_title }}</a></p>
        <p class="zxi_content">{{ shortifycontent }}</p>
        <p class="zxi_time" >{{ news_time }}</p>
        <p class="zxi_zt">状态:{{news_zt}}</p>
       
        </div>
        </div>`,
    props:{
        news_title:String,
        news_id:String,
        news_time:String,
        news_img:String,
        news_content:String,
        myclassname:String,
        news_zt:String,
    },
    computed:{
        shortifycontent(){
            if(this.news_content==null)
                return "无内容";
            if(this.news_content.length<=150)
                return this.news_content;
            else
                return this.news_content.slice(0,100)+"...";
        }
    },
    methods:{
        readthisnews()
        {
            sessionStorage.setItem("mynews_id",this.news_id);
            window.location.href="/zxck";
        }
    }
})

/*
 * 返回按钮组件
 *  myclassname 设置class
 */
Vue.component("gotoback",{
    template:`
        <span :class="myclassname"  @click="dogoback" ><img style="width: 90px;height: 78px"  >返回</span>
    `,
    methods: {
        dogoback(){
            history.back();
        }
    },
    props: {
        myclassname: String,
    }
});

var setvue=new Vue({
    el:"#header_setting",
    data: {
        bgsisshow:false,
        bgslist:[
        ],

    },
    methods:{
        bgsettingshow() {
            this.bgsisshow=!this.bgsisshow;
        },
        changebg(which){
            document.documentElement.style.setProperty("--bgimg",'url("'+this.bgslist[which].var+'")')
            sessionStorage.setItem("bgpic",this.bgslist[which].var);
        }

    }

},)
var now_bg=sessionStorage.getItem("bgpic");
if(now_bg!=null)
{
    document.documentElement.style.setProperty("--bgimg",'url("'+now_bg+'")');
}
for(var i=1;i<21;i++){
    var bgp={src:"",var:""};
    bgp.src="image/background/"+i+".jpg";
    bgp.var="../"+bgp.src;
    setvue.bgslist.push(bgp);
}
Vue.component("note",{
    template:`
        <div :class="myclassname">
        <img class="zxi_pic" :src="note_img" />
        <div class="zxi_text">
        <p class="zxi_title" @click="readthisnote" >{{ note_title }}</a></p>
        <p class="zxi_content">{{ shortifycontent }}</p>
        <p class="zxi_time" >{{ note_time }}</p>
        </div>
        </div>`,
    props:{
        note_title:String,
        note_id:String,
        note_time:String,
        note_img:String,
        note_content:String,
        myclassname:String,
    },
    computed:{
        shortifycontent(){
            if(this.note_content.length<=150)
                return this.note_content;
            else
                return this.note_content.slice(0,100)+"...";
        }
    },
    methods:{
        readthisnote()
        {
            sessionStorage.setItem("mynoteid",this.note_id);
            window.location.href="/note";
        }
    }
})
Vue.component("zzc",{
    template:` <div 
 style="position:absolute;
 pointer-events:none;
 width: 100%;
 height: 100%;
 background:rgba(255,255,255,0.5)">
</div>`,

})
Vue.component("datapiece",
    {
        template:`
        <table class="administrator_table">
            <tr :class="myclassname">
        <td class="zixun_td1">{{number}}</td>
        <td class="zixun_td1">{{dauthor}}</td>
        <td class="zixun_td1">
            <span @click="checkcontent">点此查看</span>
        </td>
        <td class="zixun_td1">{{dtime}}</td>
        <td class="zixun_td1">{{gettype}}</td>
        <td class="zixun_td1">
            <button class="admin_button" style="background: rgba(0,128,0,0.8)"  @click="pass">通过</button>
        </td>
        <td class="zixun_td1">
            <button class="admin_button" style="background: rgba(128,0,0,0.8)" @click="reject">驳回</button>
        </td>
    </tr>  </table>  `,
        props:{
            dauthor:String,
            dtime:String,
            dtype:String,
            did:String,
            myclassname:String,
            number:String,
        },
        computed:{
            gettype(){
                switch (this.dtype) {
                    case "news":
                        return "资讯";
                        break;
                    case "note":
                        return "笔记";
                        break;
                    case "goods":
                        return "商品";
                        break;
                }
            }
        },
        methods:{
            checkcontent(){
                var tlink;
                switch (this.dtype) {
                    case "news":
                        tlink="/zxck";
                        sessionStorage.setItem("mynews_id",this.did);
                        break;
                    case "note":
                        tlink="/note";
                        sessionStorage.setItem("mynote_id",this.did);
                        break;
                    case "goods":
                        tlink="/note";
                        sessionStorage.setItem("mynews_id",this.did);
                        break;
                }
                window.location.href=tlink;
            },pass:function () {

                axios.post('/admin1', {
                    admin:"1",
                    id:this.did
                }).then(function (response) {
                    alert(response.data.msg)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            reject:function () {
                axios.post('/admin1', {
                    admin:"2",
                    id:this.did
                }).then(function (response) {
                    alert(response.data.msg)
                    window.location.href="/admin";
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            }

        },

    }
)
Vue.component("delete",{
    template:`
        <span @click="dodelete">
            删除
        </span>`,
    methods:{
        dodelete(){
            console.log("尝试删除"+this.delete_id+"::"+this.delete_type)
            axios.post("/delet",{id:this.delete_id,variable:this.delete_type})
                .then(function (response) {
                    console.log("删除成功")
                })
                .catch(function (error) {
                    console.log(error)

                })
        }
    },
    props:{
        delete_type:String,
        delete_id:String,
    }
})

var tx=document.getElementById("header_tx");
console.log("头像："+sessionStorage.getItem("img"))
tx.src=sessionStorage.getItem("img");