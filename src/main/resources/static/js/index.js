import {TaskApi} from "./TaskApi.js"
import {TaskElement} from "./TaskElement.js"

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
        const taskDiv = createTaskElement(task);

        taskList.appendChild(taskDiv);
    })
}

function createTaskElement(task) {
    const taskElement = new TaskElement();

    taskElement.createTaskElement(task);

    taskElement.taskDiv.addEventListener("dblclick", function () {
        selectedTaskId = task.id;
    })

    return taskElement.taskDiv;
}

async function removeTask(){
    if(selectedTaskId === null) {
        alert("Please select a task by double clicking to remove");
        return;
    }

    await taskApi.deleteTask(selectedTaskId);

    selectedTaskId = null;

    await loadTasksToList();
}

loadTasksToList();