import { request } from "@/request/reuqest";

export const getLoginUserInfo = () => {
    return request.get('/user/getLoginUserInfo')
}