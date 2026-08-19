const taskInput = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");
const addButton = document.getElementById("addButton");

addButton.addEventListener("click", addTask);

async function addTask() {
    const task = taskInput.value.trim();

    if(task === "") {
        alert("Please enter task name");
        return;
    }
    await fetch("/tasks", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            task: task
        }),
    });
    taskInput.value = "";
    await loadTasksToList();
}
async function getTasks(){
    const response = await fetch("/tasks");

    if(!response.ok){
        alert("Could not load tasks!");
        return;
    }

    const tasks = await response.json();
    return tasks;
}

async function loadTasksToList(){
    const tasks = await getTasks();

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
        taskList.appendChild(taskDiv);
    })
}

loadTasksToList();