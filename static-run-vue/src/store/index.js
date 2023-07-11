import { createLogger, createStore } from 'vuex'
import regexp from '@/store/modules/regexp'
import user from "@/store/modules/user";
import system from "@/store/modules/system";

const isProd = import.meta.env.PROD

export default createStore({
    modules: {
        regexp,
        user,
        system
    },
    strict: isProd,
    plugins: isProd ? [] : [ createLogger() ]
})