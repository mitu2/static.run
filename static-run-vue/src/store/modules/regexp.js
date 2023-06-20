const state = () => ({
    items: []
})

const getters = {

}

const mutations = {

    addRegexpRecord(state, name) {
        if(typeof name !== 'string') {
            return
        }
        state.items.push({
            name,
            option: {
                match: {
                    // 匹配 ^
                    start: false,
                    // 匹配 $
                    end: false
                },
                // 是否反转查询
                isReverseSelection: false,
                isUnixLines: false,
                isCaseInsensitive: false,
                isComments: false,
                isMultiline: false,
                isDotall: false,
                isUnicodeCase: false,
                isCanonEq: false,
            },
            child: []
        })
    }
}

const actions = {

}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}