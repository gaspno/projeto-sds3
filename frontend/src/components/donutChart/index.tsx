
import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { saleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type chartData={
    labels :string[]
    series :number[]
}



function  DonutChart() {
    const [cData,setCData]=useState<chartData>({labels:[],series:[]});
    useEffect(()=>{

        axios.get(BASE_URL+"/sales/sum-by-seller")
        .then((response)=>{
            const data=response.data as saleSum[];
            const myLabels=data.map(x=>x.sellerName)
            const mySeries=data.map(x=>x.sum)
            setCData({labels:myLabels,series:mySeries})
       
        })
    },[])   


   // const mockData = {
  //      series: [477138, 499928, 444867, 220426, 473088],
  //      labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  //  }
    
    const options = {
        legend: {
            show: true
        }
    }
    return (
     <Chart
        options ={{...options,labels:cData.labels}}
        series={cData.series}
        type="donut"
        height="240"

       
     
     />
    );
}
export default DonutChart;

