
const monitorForm = document.getElementById('monitor-form');
const fechaInicio = document.getElementById('fecha-inicio');
const fechaFin = document.getElementById('fecha-fin');
const exportarAExcel = document.getElementById('exportar-excel');
const checkSlider = document.getElementById('check-slider');

////// data level
const tableHead = document.getElementById('table-head');
const mensajeInicial = document.getElementById('mensaje-inicial');
const tableData = document.getElementById('table-data');
const registros = document.getElementById('registros');
let index = 0;
//// end points

const endpointUrl = 'http://localhost:8080/api/json/data.json';

////

async function getJsonData(url) {
    try {
        const response = await axios.get(url + "?fechaInicio=" + fechaInicio.value + "&fechaFin=" + fechaFin.value );
        const responseData = response.data;
        buildInterface(responseData);
    } catch (error) {
        console.error(error);
    }
}

function buildInterface(data) {

    index = 0;

    if(data.length === 0){

        mensajeInicial.style.display = "block";
        mensajeInicial.innerHTML = "No hay datos disponibles";
        mensajeInicial.style.color = "red";
        index = 0;

    }else {

        while(tableData.hasChildNodes()){
            tableData.removeChild(tableData.firstChild);
        }

        data.forEach((item) => {

            tableData.insertRow().innerHTML =
                "<th scope='row' >" + (index + 1).toString() + "</th>" +
                "<td>" + item["cliente"] + "</td>" +
                "<td>" + item["clave pedimento"] + "</td>" +
                "<td>" + item["tipo operacion"] + "</td>" +
                "<td>" + item["referencia"] + "</td>" +
                "<td>" + item["pedimento"] + "</td>" +
                "<td>" + item["remesa"] + "</td>" +
                "<td>" + item["caja"] + "</td>" +
                "<td>" + item["sello"] + "</td>" +
                "<td>" + item["DODA"] + "</td>" +
                "<td>" + item["CP folios"] + "</td>" +
                "<td>" + item["cruce/SOIA"] + "</td>" +
                "<td>" + item["usuario"] + "</td>" +
                "<td>" + item["TIEMPO RECIBO BGTS"] + "</td>" +
                "<td>" + item["TIEMPO ACG CONFIRMADO"] + "</td>" +
                "<td>" + item["FECHA CCP"] + "</td>" +
                "<td>" + item["Fecha de remesa"] + "</td>";

            index += 1;
        })

        tableHead.style.display = "block";
        mensajeInicial.style.display = "none";



    }

    registros.style.display = "block";
    registros.innerHTML = "Registros: " + index.toString() + "<br />";
}

function myCallBack(){


    if( fechaInicio.value !== "" && fechaFin.value !== ""){


        let start = new Date(fechaInicio.value).getTime();
        let end = new Date(fechaFin.value).getTime();

        if(start < end){
            getJsonData(endpointUrl);
        }else{
            mensajeInicial.style.display = "block";
            mensajeInicial.innerHTML = "Error: la fecha de inicio no debe superponerse a la fecha de finalización";
            mensajeInicial.style.color = "red";
            index = 0;
        }




    }else{
        mensajeInicial.style.display = "block";
        mensajeInicial.innerHTML = "Aplique los filtros requeridos y haga click en buscar";
        mensajeInicial.style.color = "cadetblue";
        tableHead.style.display = "none";
        registros.style.display = "none";
        index = 0;
    }
}


function appliedFilters(e){


    e.preventDefault();
    console.log("clear");
    myCallBack();



    // -- Call up the data from the provided endpoint


}

function convertirAExcel(e){

    e.preventDefault();
    if(index > 0 ) {

        let downloadLink;
        let dataType = 'application/vnd.ms-excel;base64,';
        let tableHtml = document.getElementById("table-container");
        let fileName = '1716417755841.xls';

        downloadLink = document.createElement('a');
        document.body.appendChild(downloadLink);

        if (navigator.msSaveOrOpenBlob) {

            let blob = new blob(['\ufeff', tableHtml], {
                type: dataType
            });

            navigator.msSaveOrOpenBlob(blob, fileName);
        } else {


            let excelTemplate = '<html> ' +
                '<head> ' +
                '<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/> ' +
                '</head> ' +
                '<body> ' +
                tableHtml.innerHTML +
                '</body> ' +
                '</html>'

            downloadLink.href = 'data:' + dataType + window.btoa(excelTemplate);
            downloadLink.download = fileName;

            downloadLink.click();


        }

    }


}

let onOrOff = false;
let intervalId;


function clickEvent(){

    if(onOrOff === false){

        intervalId = setInterval(myCallBack, 1000);


        onOrOff = true;
    }else{
        clearInterval(intervalId);

        onOrOff = false;
    }

}




monitorForm.addEventListener('submit', appliedFilters);
exportarAExcel.addEventListener('submit', convertirAExcel);
checkSlider.addEventListener('click', clickEvent )

