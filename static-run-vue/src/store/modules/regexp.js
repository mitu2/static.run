const state = () => ({
    items: []
})

const getters = {}

const mutations = {

    addRegexpRecord({ items }, name) {
        if (typeof name !== 'string') {
            return
        }
        items.push({
            name,
            option: {
                isMatchStart: false,
                isMatchEnd: false,
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
            text: '',
            child: []
        })
    }
}

const actions = {}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}