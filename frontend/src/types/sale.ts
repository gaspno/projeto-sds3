import { seller } from "./sellers"


export type saleSum={
    sellerName: string
    sum: number
}


export type saleSucess={
    sellerName: string
    visited: number
    deals: number
}
export type sale={
    id: number
    visited: number
    deals:number
    amount: number
    date: string
    seller:seller
}
export type salePage={
    content?:sale[]
    last: boolean
    totalPages: number
    totalElements: number
    first: boolean
    size?: number
    number: number
    numberOfElements?: number
    empety?: boolean
}
