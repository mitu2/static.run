import "./assets/main.css"
import 'vfonts/FiraCode.css'

import { createApp } from "vue"

import App from "./App.vue"
import router from "@/router";
import store from "@/store";
import { axiosInstall } from "@/request"

createApp(App)
    .use(router)
    .use(store)
    .use(axiosInstall)
    .mount('#app')
