import { createLogger, createStore } from 'vuex'
import regexp from '@/store/modules/regexp'
import user from "@/store/modules/user";

const isProd = import.meta.env.PROD

export default createStore({
    modules: {
        regexp,
        user
    },
    strict: isProd,
    plugins: isProd ? [] : [ createLogger() ]
})