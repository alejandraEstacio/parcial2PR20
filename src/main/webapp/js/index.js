const tarea = document.getElementById('tarea');
const date = document.getElementById('date');
const insertBTN = document.getElementById('insertBTN');
const tableTareas = document.getElementById('tableTareas');
const tableTareasDoing = document.getElementById('tableTareasDoing');
const tableTareasDone = document.getElementById('tableTareasDone');

const insertarTarea = () =>{
    let tareaObj ={
        id:0,
        date: date.value,
        tarea: tarea.value,     
    
    };
    console.log(JSON.stringify(tareaObj));

    //POST
    let xhr = new XMLHttpRequest();
    //Response
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState===4){
            console.log(xhr.responseText);
            getAllTareas();
            getAllTareasDoing();
            getAllTareasDone();
        }
    });
    xhr.open('POST', 'http://localhost:8080/parcial2/api/tareas/create');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(tareaObj));
};

insertBTN.addEventListener('click', insertarTarea);

const getAllTareas=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState ===4){
            let json=xhr.responseText;
            let response = JSON.parse(json);
            console.log(xhr.responseText);

            for(let i=0; i<response.length; i++){
                let tareaDTO = response[i];
                let view = new TareaView(tareaDTO);
                tableTareas.appendChild(view.render());
            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/parcial2/api/tareas/allDoTo' );
    xhr.send();
};

getAllTareas();

const getAllTareasDoing =()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState ===4){
            let json=xhr.responseText;
            let response = JSON.parse(json);
            console.log(xhr.responseText);
            for(let i=0; i<response.length; i++){
                let tareaDTO = response[i];
                let view = new TareaDoing(tareaDTO);
                tableTareasDoing.appendChild(view.render());
            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/parcial2/api/tareas/allDoing' );
    xhr.send();
};

getAllTareasDoing();

const getAllTareasDone =()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState ===4){
            let json=xhr.responseText;
            let response = JSON.parse(json);
            console.log(xhr.responseText);
            for(let i=0; i<response.length; i++){
                let tareaDTO = response[i];
                let view = new TareaDone(tareaDTO);
                tableTareasDone.appendChild(view.render());
            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/parcial2/api/tareas/allDone' );
    xhr.send();
};

getAllTareasDone();
