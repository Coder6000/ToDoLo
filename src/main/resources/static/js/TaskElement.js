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
        this.taskCheckButton = document.createElement("button");

        this.taskCheckButton.type = "checkbox";
        this.taskCheckButton.value = task.task;
        this.taskCheckButton.id = task.id;
    }

    createTaskLabel(task){
        this.taskLabel = document.createElement("label");

        this.taskLabel.textContent = task.task;
        this.taskLabel.type = "label";
    }

    createTaskDiv(){
        this.taskDiv = document.createElement("div");

        this.taskDiv.append(this.taskCheckButton);
        this.taskDiv.append(this.taskLabel);
    }
}