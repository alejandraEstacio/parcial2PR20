class TareaDoing{

    constructor(tarea){
        this.tarea = tarea;
        this.onDeleteFinish = null;
    }

    deleteTarea=()=>{
        alert('esta tarea tiene el id'+this.tarea.id);
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState ===4){
                if(this.onDeleteFinish !=null) this.onDeleteFinish();

            }
        });
        xhr.open('DELETE','http://localhost:8080/parcial2/api/tareas/delete/'+this.tarea.id);
        xhr.send();

    }
    pasarTarea=()=>{
        alert('esta tarea tiene el id'+this.tarea.id);
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState ===4){
            }
        });
        xhr.open('PUT','http://localhost:8080/parcial2/api/tareas/modificarDoing/'+this.tarea.id);
        xhr.send();
    }

    volverTarea=()=>{
        alert('esta tarea tiene el id'+this.tarea.id);
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState ===4){
            }
        });
        xhr.open('PUT','http://localhost:8080/parcial2/api/tareas/retrocederDoing/'+this.tarea.id);
        xhr.send();
    }
    render = ()=>{
        let component = document.createElement('div');
        component.className ='tareaComponent';
        let fecha = document.createElement('small');
        let texto = document.createElement('p');
        let delBtn = document.createElement('button');
        let modBtn = document.createElement('button');
        let volBtn = document.createElement('button');
        delBtn.innerHTML = 'X';
        delBtn.className = 'delBtn';
        volBtn.innerHTML = '<-';
        volBtn.className = 'volBtn';
        modBtn.innerHTML = '->';
        modBtn.className = 'modBtn';

        fecha.innerHTML = this.tarea.fecha;
        texto.innerHTML = this.tarea.tarea;
        component.appendChild(fecha);
        component.appendChild(texto);
        component.appendChild(delBtn);
        component.appendChild(volBtn);
        component.appendChild(modBtn);


        delBtn.addEventListener('click', this.deleteTarea);
        modBtn.addEventListener('click', this.pasarTarea);
        volBtn.addEventListener('click', this.volverTarea);

        return component;
    }

    
}