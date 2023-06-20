import { useStore } from "vuex";

export default (module) => {
    const store = useStore()
    return {
        state: store.state[module],
        getters: store.getters[module],
        commit(type, payload, options) {
            return store.commit(module + '/' + type, payload, options)
        },
        dispatch(type, payload, options) {
            return store.dispatch(module + '/' + type, payload, options)
        },
    }
}