import { request } from "@/request/reuqest";

export const getSysConfig = () => {
    return request.get('/sys-info/getSysConfig')
}