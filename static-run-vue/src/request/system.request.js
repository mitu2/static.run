import { request } from "@/request";

export const getSysConfig = () => {
    return request.get('/sys-info/getSysConfig')
}