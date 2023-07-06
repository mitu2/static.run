import { request } from "@/request/axios.reuqest";

export const getSysConfig = () => {
    return request.get('/sys-info/getSysConfig')
}