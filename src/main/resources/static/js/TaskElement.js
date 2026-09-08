export class TaskElement {
    taskCheckButton;
    taskLabel;
    taskDiv;

    createTaskElement(task) {
        this.createTaskCheckButton(task);
        this.createTaskLabel(task);
        this.createTaskDiv();
    }

    createTaskCheckButton(task){
        this.taskCheckButton = document.createElement("input");

        this.taskCheckButton.type = "checkbox";
        this.taskCheckButton.value = task.task;
        this.taskCheckButton.id = task.id;
        this.taskCheckButton.classList.add("task-checkbox");
    }

    createTaskLabel(task){
        this.taskLabel = document.createElement("label");

        this.taskLabel.textContent = task.task;
        this.taskLabel.id = task.id;
        this.taskLabel.classList.add("task-label");
    }

    createTaskDiv(){
        this.taskDiv = document.createElement("div");

        this.taskDiv.append(this.taskCheckButton);
        this.taskDiv.append(this.taskLabel);
        this.taskDiv.classList.add("task-element-container");
    }
}