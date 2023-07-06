import "./assets/main.css"
import "vfonts/Lato.css"

import { createApp } from "vue"

import App from "./App.vue"
import router from "@/router";
import store from "@/store";
import { axiosInstall } from "@/request/axios.reuqest"

createApp(App)
    .use(router)
    .use(store)
    .use(axiosInstall)
    .mount('#app')
