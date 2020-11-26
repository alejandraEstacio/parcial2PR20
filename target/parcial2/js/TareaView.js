class TareaView{

    constructor(tarea){
        this.tarea = tarea;
    }

    deleteTarea=()=>{
        alert('la tarea con el id: '+this.tarea.id+'se ha eliminado correctamente');
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState ===4){
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
        xhr.open('PUT','http://localhost:8080/parcial2/api/tareas/modificarToDo/'+this.tarea.id);
        xhr.send();

    }

    render = ()=>{
        let component = document.createElement('div');
        component.id ='tarea' +this.tarea.id;
        component.className ='tareaComponent';
        let fecha = document.createElement('small');
        let texto = document.createElement('p');
        let delBtn = document.createElement('button');
        let modBtn = document.createElement('button');
        delBtn.innerHTML = 'X';
        delBtn.className = 'delBtn';
        modBtn.innerHTML = '->'
        modBtn.className = 'modBtn';

        fecha.innerHTML= this.tarea.fecha;
        texto.innerHTML = this.tarea.tarea;
        component.appendChild(fecha);
        component.appendChild(texto);
        component.appendChild(delBtn);
        component.appendChild(modBtn);

        delBtn.addEventListener('click', this.deleteTarea);
        modBtn.addEventListener('click', this.pasarTarea);


        return component;
    }

    
}