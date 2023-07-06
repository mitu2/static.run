import axios from "axios";

export const request = axios.create({
    // TODO: replace .env
    baseURL: 'http://api.local.static.run:8091'
})

export const axiosInstall = (plugin) => {
    plugin.config.globalProperties.$request = request
}