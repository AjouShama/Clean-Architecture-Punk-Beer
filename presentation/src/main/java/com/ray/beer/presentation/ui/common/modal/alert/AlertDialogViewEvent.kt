package com.ray.beer.presentation.ui.common.modal.alert

sealed interface AlertDialogViewEvent {
    object OnCancel : AlertDialogViewEvent
    object OnConfirm : AlertDialogViewEvent
}