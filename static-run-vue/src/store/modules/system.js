import { getSysConfig } from "@/request/system.request";

const state = () => ({
    theme: undefined,
    sysConfig: {}
})

const getters = {

    getSysConfig(state) {
        return state.sysConfig
    }

}

const mutations = {

    setSysConfig(state, payload) {
        state.sysConfig = Object.assign({}, payload, {
            installDate: new Date(payload.installDate),
            lastStopDate: new Date(payload.lastStopDate),
            startDate: new Date(payload.startDate),
        })
    }

}

const actions = {
    initSysConfig({ commit }) {
        getSysConfig().then(res => {
            commit('setSysConfig', res.data)
        }).catch(err => {
            console.error("ajax initSysConfig error: ", err)
        })
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}