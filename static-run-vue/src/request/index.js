import axios from "axios";

export const request = axios.create({
    baseURL: import.meta.env.VITE_API_URL,
    withCredentials: true
})

export const axiosInstall = (plugin) => {
    plugin.config.globalProperties.$request = request
}