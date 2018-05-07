<template>
    <div class="message-mail">
        <div class="message-box">
            <ul>
                <li>
                    <span class="time">2018-4-25</span>
                    <span class="circle"></span>
                    <dl>
                        <dd>
                            <p class="title-p"><a>存在延期任务<i>2</i>条<i class="iconfont icon-arrowdown"></i></a></p>
                            <div class="dd-list">
                                <dl class="list-dl">
                                    <dd>
                                        <span>PMT项目</span>
                                        <span>登录功能开发</span>
                                        <span>开始时间2018-03-01</span>
                                        <span>已延期2天</span>
                                    </dd>
                                </dl>
                            </div>
                        </dd>
                        <dd>
                            <p class="title-p"><a>存在延时任务<i>2</i>条<i class="iconfont icon-arrowdown"></i></a></p>
                        </dd>
                    </dl>
                </li>
                <li>
                    <span class="time">2018-4-24</span>
                    <span class="circle"></span>
                    <dl>
                        <dd>
                            <p class="title-p"><a>存在延期任务<i>2</i>条<i class="iconfont icon-arrowdown"></i></a></p>
                        </dd>
                        <dd>
                            <p class="title-p"><a>存在延时任务<i>2</i>条<i class="iconfont icon-arrowdown"></i></a></p>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</template>
<style scoped lang="less">
   .message-mail{
       width:100%;
       margin:0 auto;
       .message-box{
           width:80%;
           height:100%;
           background:#fff;
           margin:20px auto 0;
           min-height:550px;
           border-radius:10px;
           ul{
               width:60%;
               border-left:1px solid #eee;
               margin-left:30%;
               padding:40px 0;
               li{
                   position: relative;
                   margin:0 0 25px 40px;
                   line-height:25px;
                   border:1px solid #eee;
                   padding:10px;
                   border-radius:10px;
                   .time{
                       height:25px;
                       line-height: 25px;
                       font-size:20px;
                       color:#666;
                       position: absolute;
                       left:-170px;
                       top:50%;
                       margin-top:-12.5px;
                   }
                   .circle{
                       display:block;
                       width:15px;
                       height:15px;
                       background:#fff;
                       border:2px solid #eee;
                       border-radius:50px;
                       position: absolute;
                       left:-49px;
                       top:50%;
                       margin-top:-8px;

                   }
                   dd{
                       /* position: relative; */
                       .title-p{
                           i{
                               font-weight:bold;
                               margin:0 5px;
                           }
                           .iconfont{
                               font-size:14px;
                           }
                       }
                       .list-dl{
                           width:100%;
                           background:#fff;
                           height:0;
                           transition:height 0.5s;
                           -webkit-transition:height 0.5s;
                           -ms-transition:height 0.5s;
                           -o-transition:height 0.5s;
                           -moz-transition:height 0.5s;
                           overflow:hidden;
                           dd{
                               padding:0 10px;
                           }
                       }
                       
                   }
                   dd:hover{
                        .list-dl{ 
                            height:150px;
                            overflow-y:auto;
                        }
                        .title-p{
                           .iconfont{
                               display:inline-block;
                               transform:rotateZ(180deg);
                           }
                       }
                   }
               }
           }

       }
   } 
</style>