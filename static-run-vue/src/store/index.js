import { createStore, createLogger } from 'vuex'
import regexp from '@/store/modules/regexp'

const debug = import.meta.env.PROD

export default createStore({
    modules: {
        regexp
    },
    strict: debug,
    plugins: debug ? [createLogger()] : []
})