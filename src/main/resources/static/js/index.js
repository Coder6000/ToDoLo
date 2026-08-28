import {TaskApi} from "./TaskApi.js"

const taskApi = new TaskApi();

const taskInput = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");
const addButton = document.getElementById("addButton");
const removeButton = document.getElementById("removeButton");

let selectedTaskId = null;

addButton.addEventListener("click", addTask);
removeButton.addEventListener("click", removeTask);

async function addTask() {
    const task = taskInput.value.trim();

    if(task === "") {
        alert("Please enter task name");
        return;
    }

    await taskApi.createTask(task);

    taskInput.value = "";
    await loadTasksToList();
}

async function loadTasksToList(){
    const tasks = await taskApi.getTasks();

    taskList.innerHTML = "";

    tasks.forEach((task) => {
        const taskDiv = document.createElement("div");
        const taskCheckButton = document.createElement("input")
        const taskLabel = document.createElement("label");
        taskCheckButton.type = "checkbox";
        taskCheckButton.value = task.task;
        taskCheckButton.id = task.id;

        taskLabel.textContent = task.task;
        taskLabel.htmlFor = task.id;

        taskDiv.appendChild(taskCheckButton);
        taskDiv.appendChild(taskLabel);

        taskDiv.addEventListener("dblclick", function () {
            selectedTaskId = task.id;
        })

        taskList.appendChild(taskDiv);
    })
}

async function removeTask(){
    await taskApi.deleteTask(selectedTaskId);
    selectedTaskId = null;

    await loadTasksToList();
}

loadTasksToList();