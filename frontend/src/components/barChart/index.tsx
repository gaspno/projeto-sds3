
import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { saleSucess } from 'types/sale';
import { BASE_URL } from 'utils/requests';
import { round } from 'utils/format';
type seriesData={
    name:string;
    data:number[]
}

type chartData={
    labels:{
        categories:string[]
    }
    series:seriesData[]

}


function  BarChart() {
const [cData,setCData]=useState<chartData>({
    labels: {
        categories: []
    },
    series: [
        {
            name: "% Sucesso",
            data: []                   
        }
    ]

})
useEffect(()=>{

    axios.get(BASE_URL+"/sales/sucess-by-seller")
    .then((response)=>{
        const data=response.data as saleSucess[]
        const myLabels=data.map(x=>x.sellerName)
        const mySeries=data.map(x=>round(100*(x.deals/x.visited),2))
      
        setCData({
            labels: {
                categories: myLabels
            },
            series: [
                {
                    name: "% Sucesso",
                    data: mySeries                  
                }
            ]
        
        })        
    })
},[])   

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    
    return (
     <Chart
        options ={{...options,xaxis:cData.labels}}
        series={cData.series}
        type="bar"
        height="240"

       
     
     />
    );
}
export default BarChart;

