<template>
        <div class="demand-list">
            <ul class="demand-list-ul">
                <li>
                    <span>01.01.01</span>
                    <span>用户名判断是否存在</span>
                    <span><Tag color="#ff0000">P1</Tag></span>
                    <div class="brief-text">
                        <p>登录功能主要让使用该平台的人员能够登录到该平台中，需要对登录的人员做登录前的验证，判断用户是否在系统中存在，密码是否输入正确，如果正确，允许用户进入系统，如果错误，提示用户名或密码有误，请重新输入.</p>
                    </div>
                    <dl class="bottom-operations cl">
                        <dd class="fl"><i class="iconfont icon-time"></i>2018.04.05</dd>
                        <dd class="fl"><Tag color="#33ccff">蔡长庆</Tag></dd>
                        <dd class="fr"><i class="iconfont icon-icon7" title="删除"></i></dd>
                    </dl>  
                </li>
            </ul>
            <Page :total="100"></Page>
        </div>
    </template>
    <script>
        export default {
            data () {
                return {
                    accordion:true,
                }
            }
        }
    </script>
    <style scoped lang="less">
        
    </style>